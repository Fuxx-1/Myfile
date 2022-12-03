package ltd.newimg.structural.facade;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 20:19
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
