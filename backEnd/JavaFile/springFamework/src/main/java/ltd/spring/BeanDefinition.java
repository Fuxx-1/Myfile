package ltd.spring;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 11:11
 */
public class BeanDefinition {

    private Class clazz;
    private String scope;



    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
