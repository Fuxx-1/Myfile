import java.util.*;

public class H {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), count;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    count++;
                }
            }
            System.out.printf("%d", count);
            if (i - 1 != n) {
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}