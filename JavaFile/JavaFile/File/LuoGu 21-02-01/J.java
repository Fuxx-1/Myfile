import java.util.*;

public class J {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[20][20];
        int k = 1, x = 1, y = 0;
        while (k <= n * n) {
            while (y < n && a[x][y + 1] == 0) a[x][++y] = k++;
            while (x < n && a[x + 1][y] == 0) a[++x][y] = k++;
            while (y > 1 && a[x][y - 1] == 0) a[x][--y] = k++;
            while (x > 1 && a[x - 1][y] == 0) a[--x][y] = k++;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }

    }
}