package ltd.newimg.creational.abstractFactory.factory;

import ltd.newimg.creational.abstractFactory.color.Color;
import ltd.newimg.creational.abstractFactory.shape.Shape;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:29
 */
public interface AbstractFactory {
    public default Color getColor(String color) {
        throw new RuntimeException("MethodNotComplete");
    }
    public default Shape getShape(String shape) {
        throw new RuntimeException("MethodNotComplete");
    }
}
