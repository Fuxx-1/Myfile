import java.util.*;

public class C {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i;
        }
        System.out.println(ans);
    }
}
