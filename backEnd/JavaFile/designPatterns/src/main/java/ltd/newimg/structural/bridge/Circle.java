package ltd.newimg.structural.bridge;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:03
 */
public class Circle extends Shape{
    private int radius;

    protected Circle(int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius);
    }
}
