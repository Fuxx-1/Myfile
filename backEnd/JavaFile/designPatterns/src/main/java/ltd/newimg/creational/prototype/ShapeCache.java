package ltd.newimg.creational.prototype;

import java.util.Hashtable;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:02
 */
public class ShapeCache {
    private static final Hashtable<String, Shape> shapeTable = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeTable.get(shapeId);
        return cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeTable.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeTable.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeTable.put(rectangle.getId(),rectangle);
    }
}
