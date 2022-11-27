package ltd.newimg.creational.factory.test;

import ltd.newimg.creational.factory.factory.ShapeFactory;
import ltd.newimg.creational.factory.Shape;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 20:44
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape;
        try {
            shape = shapeFactory.getShape("Circle");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        shape.draw();
    }
}
