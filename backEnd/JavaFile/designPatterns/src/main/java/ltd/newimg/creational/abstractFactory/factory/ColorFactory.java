package ltd.newimg.creational.abstractFactory.factory;

import ltd.newimg.creational.abstractFactory.color.Blue;
import ltd.newimg.creational.abstractFactory.color.Color;
import ltd.newimg.creational.abstractFactory.color.Green;
import ltd.newimg.creational.abstractFactory.color.Red;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:40
 */
public class ColorFactory implements AbstractFactory{
    @Override
    public Color getColor(String color) {
        switch (color.toLowerCase()) {
            case "red":
                return new Red();
            case "green":
                return new Green();
            case "blue":
                return new Blue();
            default:
                throw new RuntimeException("ColorNotSupport");
        }
    }
}
