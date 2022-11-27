package ltd.newimg.creational.factory.factory;

import ltd.newimg.creational.factory.Circle;
import ltd.newimg.creational.factory.Rectangle;
import ltd.newimg.creational.factory.Shape;
import ltd.newimg.creational.factory.Square;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 20:21
 */
public class ShapeFactory {

    public Shape getShape(String shapeType) throws Exception {
        switch (shapeType) {
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
            case "Circle":
                return new Circle();
            default:
                throw new Exception("ShapeNotFoundException");
        }
    }
}
