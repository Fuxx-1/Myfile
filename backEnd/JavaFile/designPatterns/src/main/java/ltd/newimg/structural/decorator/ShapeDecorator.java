package ltd.newimg.structural.decorator;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 16:51
 */
public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    public void draw() {
        decoratedShape.draw();
    }
}
