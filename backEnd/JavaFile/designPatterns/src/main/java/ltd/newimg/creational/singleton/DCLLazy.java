package ltd.newimg.creational.singleton;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 17:28
 */
public class DCLLazy {
    private static volatile DCLLazy instance = null;

    private DCLLazy() {
    }

    public static DCLLazy getInstance() {
        if (instance == null) {
            synchronized (Lazy.class) {
                if (instance == null) {
                    instance = new DCLLazy();
                }
            }
        }
        return instance;
    }

    public void method() {
        System.out.println("OK");
    }
}
