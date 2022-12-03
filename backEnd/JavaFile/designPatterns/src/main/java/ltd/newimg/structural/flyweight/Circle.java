package ltd.newimg.structural.flyweight;

import lombok.Setter;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 20:19
 */
@Setter
public class Circle implements Shape {
    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color: " + color
                + ", x: " + x + ", y: " + y + ", radius: " + radius + "]");
    }
}
