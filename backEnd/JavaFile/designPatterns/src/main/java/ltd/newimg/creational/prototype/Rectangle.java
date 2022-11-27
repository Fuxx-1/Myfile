package ltd.newimg.creational.prototype;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:00
 */
public class Rectangle extends Shape{

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Shape->Rectangle::draw()");
    }
}
