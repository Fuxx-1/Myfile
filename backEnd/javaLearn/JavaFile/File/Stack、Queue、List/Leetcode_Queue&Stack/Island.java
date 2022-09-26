import java.util.Scanner;

/**
 * @create: 2021-04-27 20:21
 **/
public class Island {


    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int x = Sc.nextInt(), y = Sc.nextInt();
        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a[i][j] = Sc.nextInt();
            }
        }

    }
}
