package ltd.newimg.structural.bridge;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-01 23:27
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius) {
        System.out.println("Drawing RedCircle[radius: " + radius + "]");
    }
}