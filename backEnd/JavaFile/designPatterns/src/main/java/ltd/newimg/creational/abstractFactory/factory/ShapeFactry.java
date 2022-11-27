package ltd.newimg.creational.abstractFactory.factory;

import ltd.newimg.creational.abstractFactory.shape.Circle;
import ltd.newimg.creational.abstractFactory.shape.Rectangle;
import ltd.newimg.creational.abstractFactory.shape.Shape;
import ltd.newimg.creational.abstractFactory.shape.Square;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:36
 */
public class ShapeFactry implements AbstractFactory{
    @Override
    public Shape getShape(String shape) {
        switch (shape.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                throw new RuntimeException("ShapeNotSupport");
        }
    }
}
