package ltd.newimg.creational.abstractFactory.factory;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:45
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        switch (choice.toLowerCase()) {
            case "shape":
                return new ShapeFactry();
            case "color":
                return new ColorFactory();
            default:
                throw new RuntimeException("FactoryNotSupport");
        }
    }
}
