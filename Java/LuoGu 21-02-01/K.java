import java.util.*;

public class K {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[10001];
        int count = 0;
        while (n != 1) {
            a[count] = n;
            if ((n % 2) == 1) {
                n = 3 * n + 1;
            } else if ((n % 2) == 0) {
                n = n / 2;
            }
            count++;
        }
        a[count] = n;
        for (int i = count; i >= 0; i--) {
            System.out.printf("%d", a[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }
}
