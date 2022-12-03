package ltd.newimg.structural.proxy;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 19:57
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // 双检锁
        if (realImage == null) {
            synchronized (RealImage.class) {
                if (realImage == null) {
                    realImage = new RealImage(fileName);
                }
            }
        }
        realImage.display();
    }
}
