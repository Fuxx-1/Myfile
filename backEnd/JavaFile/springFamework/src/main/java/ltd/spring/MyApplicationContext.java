package ltd.spring;

import ltd.spring.anno.AutoWired;
import ltd.spring.anno.Component;
import ltd.spring.anno.ComponentScan;
import ltd.spring.anno.Scope;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 10:07
 */
public class MyApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String, Object> singletonObjs = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<BeanPostProcessor> BeanPostProcessorList = new CopyOnWriteArrayList<>();

    public MyApplicationContext(Class configClass) {

        this.configClass = configClass;

        // 解析配置类
        // ComponentScan 注解 -> 扫描路径 -> 扫描 -> BeanDefinition -> BeanDefinitionMap
        scan(configClass);

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            if (entry.getValue().getScope().equals("singleton")) {
                // 创建Bean
                Object bean = createBean(entry.getKey(), entry.getValue());
                singletonObjs.put(entry.getKey(), bean);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        Object instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 依赖注入
        for (Field declaredField : clazz.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(AutoWired.class)) {
                // 属性复制
                declaredField.setAccessible(true);
                try {
                    declaredField.set(instance, getBean(declaredField.getName()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // Aware 回调
        if (instance instanceof BeanNameAware) {
            ((BeanNameAware) instance).setBeanName(beanName);
        }

        for (BeanPostProcessor beanPostProcessor : BeanPostProcessorList) {
            instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
        }

        // 初始化
        if (instance instanceof InitializingBean) {
            try {
                ((InitializingBean) instance).afterPropertiesSet();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        for (BeanPostProcessor beanPostProcessor : BeanPostProcessorList) {
            instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
        }

        return instance;
    }

    private void scan(Class configClass) {
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            // 解析配置类
            // ComponentScan 注解 -> 扫描路径 -> 扫描
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value(); // 扫描路径
            path = path.replace(".", "/");

            /*
            System.out.println("扫描路径: " + path);

            // 扫描
            // Bootstrap(jre/lib)、Ext(jre/ext/lib)、App(classpath)
            */

            ClassLoader classLoader = MyApplicationContext.class.getClassLoader(); // app
            URL resource = classLoader.getResource(path); // 获取目录
            File file = new File(resource.getFile()); // 获取目录下文件
            if (file.isDirectory()) {
                File[] files = file.listFiles();
//                System.out.println("目录下文件: " + Arrays.toString(files));
                for (File singleFile : files) {
                    String className = singleFile.getAbsolutePath();
                    if (className.endsWith(".class")) {
                        className = className.substring(className.indexOf(path.replace('/', '\\')), className.indexOf(".class")).replace("\\", "."); // 获取类的权限名
                        Class<?> clazz = null;
                        try {
                            clazz = classLoader.loadClass(className);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 是 Bean 对象
                            // BeanDefinition（解析类）

                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor instance;
                                try {
                                     instance = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                BeanPostProcessorList.add(instance);
                            }

                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    }
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjs.get(beanName);
            } else {
                // 创建 Bean 对象
                return createBean(beanName, beanDefinition);
            }
        } else {
            // 不存在Bean
            throw new RuntimeException("BeanNotFoundException");
        }
    }
}
