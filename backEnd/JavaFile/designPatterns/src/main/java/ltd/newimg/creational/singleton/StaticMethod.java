package ltd.newimg.creational.singleton;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 17:51
 */
public class StaticMethod {
    private static class InstanceHolder {
        private static StaticMethod instance  = new StaticMethod();
    }

    private StaticMethod() {

    }

    public static StaticMethod getInstance() {
        return InstanceHolder.instance;
    }

    public void method() {
        System.out.println("method() OK.");
    }
}
