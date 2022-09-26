import java.util.*;

public class Q {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[] math = new int[100001];
        int i, j, n = in.nextInt(), count = 0;
        boolean[] r = new boolean[100001];
        for (i = 0; i < n; i++) {
            math[i] = in.nextInt();
            r[math[i]] = true;
        }
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (r[math[i] + math[j]]) {
                    count++;
                    r[math[i] + math[j]] = false;
                }
            }
        }
        System.out.printf("%d", count);//输出
    }
}
