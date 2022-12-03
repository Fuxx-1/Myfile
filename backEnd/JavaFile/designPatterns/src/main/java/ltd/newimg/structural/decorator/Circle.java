package ltd.newimg.structural.decorator;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 16:49
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape::Circle");
    }
}
