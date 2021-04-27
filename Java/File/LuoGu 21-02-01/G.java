import java.util.*;

public class G {
    public static void main(String args[]) {
        int[][] a = new int[100][100];
        Scanner in = new Scanner(System.in);
        int count = 1, n = in.nextInt();
        a[0][0] = a[1][0] = a[1][1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < count; j++) {
                if (i != 0 && i != 1 && j != 0) {
                    a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                }
                if (i != 0 && i != 1 && j == 0){
                    a[i][j] = a[i - 1][j];
                }
                System.out.printf("%d", a[i][j]);
                if ((i - 1) != count) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            count++;
        }
    }
}