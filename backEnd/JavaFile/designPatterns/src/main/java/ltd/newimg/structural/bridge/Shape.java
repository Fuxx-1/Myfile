package ltd.newimg.structural.bridge;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:01
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
