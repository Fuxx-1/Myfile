package ltd.newimg.behavioral.publishSubscribe;


/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 12:03
 */
public interface Publisher {

    /**
     * 添加订阅者
     * @param subscriber 订阅者信息
     */
    void add(Subscriber subscriber);

    /**
     * 发布者发布消息
     * @param msg 消息
     */
    void on(String msg);

    /**
     * 移除订阅者
     * @param subscriber 订阅者信息
     */
    void remove(Subscriber subscriber);
}
