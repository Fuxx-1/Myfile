import java.util.*;

public class F {
    public static void main(String args[]) {
        Scanner in = (new Scanner(System.in));
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int b = 0, min = 0;
        for (int i = 0; i < n - m; i++) {
            b = 0;
            for (int j = 0; j < m; j++) {
                b += a[i + j];
            }
            if (b <= min || i == 0)
                min = b;
        }
        if (m == 0 || n == 0) {
            min = 0;
        } else if ((m - n) == 0) {
            for (int j = 0; j < m; j++) {
                b += a[j];
            }
            min = b;
        }
        System.out.println(min);
    }
}