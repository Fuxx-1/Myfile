package ltd.newimg.creational.prototype;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:00
 */
public class Square extends Shape{

    public Square() {
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Shape->Square::draw()");
    }
}
