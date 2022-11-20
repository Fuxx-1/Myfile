package ltd.newimg.service;

import ltd.spring.BeanPostProcessor;
import ltd.spring.anno.Component;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 13:35
 */
@Component
public class MyBeanPostprocessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("before " + beanName + " init");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("after " + beanName + " init");
        return bean;
    }
}
