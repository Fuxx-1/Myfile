package ltd.spring;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 13:23
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
