import java.util.*;

public class O {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = in.nextInt();
        }
        int min = (a[2] - a[0]) * 60 + a[3] - a[1];
        a[0] = min / 60;
        a[1] = min % 60;
        System.out.println(a[0] + " " + a[1]);
    }
}