package ltd.newimg.behavioral.publishSubscribe;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 12:17
 */
public class Main {
    public static void main(String[] args) {
        MySubscriber s1 = new MySubscriber("S1", new MySubscriber.Receiver() {
            @Override
            public void onMessage(String publisher, String msg) {
                System.out.println("[ReceiveMessage]" + publisher + "->S1");
            }
        });
        MySubscriber s2 = new MySubscriber("S2");
        MySubscriber s3 = new MySubscriber("S3");

        MyPublisher publisher = new MyPublisher("P1");
        publisher.add(s1);
        publisher.add(s2);
        publisher.add(s3);

        publisher.on("Hello");
    }
}
