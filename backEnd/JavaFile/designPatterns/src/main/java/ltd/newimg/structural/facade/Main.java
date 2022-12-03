package ltd.newimg.structural.facade;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 17:03
 */
public class Main {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
