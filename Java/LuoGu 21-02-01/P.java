import java.util.*;

public class P {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int[] d = new int[]{0, a, b, c};
        Arrays.sort(d);
        if (d[1] + d[2] <= d[3]) {
            System.out.print("Not triangle\n");
        } else {
            if (d[1] * d[1] + d[2] * d[2] == d[3] * d[3]) System.out.print("Right triangle\n");
            else if (d[1] * d[1] + d[2] * d[2] > d[3] * d[3]) System.out.print("Acute triangle\n");
            else if (d[1] * d[1] + d[2] * d[2] < d[3] * d[3]) System.out.print("Obtuse triangle\n");
            if (a == b || b == c || a == c) System.out.print("Isosceles triangle\n");
            if (a == b && b == c) System.out.print("Equilateral triangle\n");
        }
    }
}