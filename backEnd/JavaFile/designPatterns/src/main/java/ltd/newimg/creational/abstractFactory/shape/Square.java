package ltd.newimg.creational.abstractFactory.shape;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:33
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape->Square::draw()");
    }
}
