package ltd.newimg.creational.prototype;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:00
 */
public class Circle extends Shape{

    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Shape->Circle::draw()");
    }
}
