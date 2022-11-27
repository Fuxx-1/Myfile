package ltd.newimg.creational.singleton;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 17:28
 */
public class Hungry {
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    // 基于 classLoader 机制，自动达到了线程安全的效果
    public static Hungry getInstance() {
        return instance;
    }

    public void method() {
        System.out.println("OK");
    }
}

