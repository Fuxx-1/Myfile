package ltd.newimg.creational.singleton;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 17:28
 */
public class Lazy {
    private static Lazy instance = null;

    private Lazy() {
    }

    public static synchronized Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }

    public void method() {
        System.out.println("OK");
    }
}