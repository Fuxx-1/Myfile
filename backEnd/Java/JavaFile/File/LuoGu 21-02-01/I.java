import java.util.*;

public class I {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[1001], d = new int[1001];
        for (int i = 1; i <= 7; i++) {
            int b = in.nextInt();
            c[b] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int sx = 0;
            for (int j = 1; j <= 7; j++) {
                int a = in.nextInt();
                if (c[a] == 1) {
                    sx++;
                }
            }
            d[7 - sx]++;
        }
        for (int i = 0; i < 7; i++) {
            System.out.printf("%d ", d[i]);
        }
    }
}
