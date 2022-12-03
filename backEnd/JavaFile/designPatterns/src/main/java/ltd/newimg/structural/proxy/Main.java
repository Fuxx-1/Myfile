package ltd.newimg.structural.proxy;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 20:00
 */
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
