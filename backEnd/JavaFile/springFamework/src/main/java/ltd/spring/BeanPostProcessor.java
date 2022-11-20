package ltd.spring;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 13:31
 */
public interface BeanPostProcessor {
    default Object postProcessBeforeInitialization(Object bean, String beanName){
        return bean;
    };

    default Object postProcessAfterInitialization(Object bean, String beanName){
        return bean;
    };
}
