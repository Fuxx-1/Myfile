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

    public static void main(String[] args) {
        int num = 25;
        String numString = String.valueOf(num);
        int arrLength = numString.length(), result = 0;
        int[] dp = new int[arrLength];
        dp[0] = 1;
        for (int i = 1; i < arrLength; i++) {
            int index = (numString.charAt(i - 1) - '0') * 10 + numString.charAt(i) - '0';
            dp[i] = dp[i - 1] + (index < 26 ? 1 : 0);
            result = Math.max(dp[i], result);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(result);
    }

}
