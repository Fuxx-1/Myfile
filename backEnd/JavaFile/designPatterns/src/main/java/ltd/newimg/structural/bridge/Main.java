package ltd.newimg.structural.bridge;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:04
 */
public class Main {
    public static void main(String[] args) {
        Circle redCircle = new Circle(10, new RedCircle());
        Circle greenCircle = new Circle(10, new GreenCircle());

        greenCircle.draw();
        redCircle.draw();
    }
}
