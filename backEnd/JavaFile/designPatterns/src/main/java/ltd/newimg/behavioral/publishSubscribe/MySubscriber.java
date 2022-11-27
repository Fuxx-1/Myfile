package ltd.newimg.behavioral.publishSubscribe;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 12:13
 */
public class MySubscriber implements Subscriber{
    // 订阅者名称
    private String name;
    private Receiver receiver;

    public interface Receiver {
        void onMessage(String publisher, String msg);
    }

    // 创建订阅者
    public MySubscriber(String name) {
        this.name = name;
    }

    // 创建订阅者，也可以加个回调函数，用来将消息回调出去
    public MySubscriber(String name, Receiver receiver) {
        this.name = name;
        this.receiver = receiver;
    }

    @Override
    public void on(String publisher, String msg) {
        // 这里会收到发布者消息，然后做相应的处理，一般这里会创建一个回调函数，通过回调函数将消息发送出去
        System.out.println(publisher + "->" + this.name + ": " + msg);
        if (receiver != null) {
            receiver.onMessage(publisher, msg);
        }
    }
}
