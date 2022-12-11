package ltd.newimg.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 17:07
 */
public class ShapeFactory {
    public static final HashMap<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) shapeMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            shapeMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
