package ltd.newimg.structural.flyweight;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 17:12
 */
public class Main {
    private static final String colors[] =
            { "Red", "Green", "Blue", "White", "Black" };

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle =
                    (Circle)ShapeFactory.getCircle(getRandomColor());
            circle.setX((int)(Math.random()*100));
            circle.setY((int)(Math.random()*100));
            circle.setRadius(100);
            circle.draw();
        }
    }
    private static String getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
}
