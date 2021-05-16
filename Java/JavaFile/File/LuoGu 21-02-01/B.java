import java.util.*;

public class B {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if ((5 * n) < (11 + 3 * n)) {
            System.out.printf("Local");
        } else {
            System.out.printf("Luogu");
        }
    }
}
