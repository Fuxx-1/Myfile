package ltd.newimg.behavioral.publishSubscribe;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 12:04
 */
public interface Subscriber {
    /**
     * 消息监听方法
     * @param publisher 发布者
     * @param msg 消息
     */
    void on(String publisher, String msg);
}
