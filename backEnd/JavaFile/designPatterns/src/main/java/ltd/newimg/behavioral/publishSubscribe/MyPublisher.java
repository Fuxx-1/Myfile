package ltd.newimg.behavioral.publishSubscribe;

import java.util.ArrayList;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 12:08
 */
public class MyPublisher implements Publisher {

    // 定义集合用于存储订阅者
    private final ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

    // 发布者名称
    private String name;

    /**
     * 创建发布者
     * @param name 发布者信息
     */
    public MyPublisher(String name) {
        this.name = name;
    }

    /**
     * 添加订阅者
     *
     * @param subscriber 订阅者信息
     */
    @Override
    public void add(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * 发布者发布消息
     *
     * @param msg 消息
     */
    @Override
    public void on(String msg) {
        for (Subscriber subscriber : subscribers) {
            subscriber.on(name, msg);
        }
    }

    /**
     * 移除订阅者
     *
     * @param subscriber 订阅者信息
     */
    @Override
    public void remove(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
