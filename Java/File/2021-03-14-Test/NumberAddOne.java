import java.util.Scanner;

public class NumberAddOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] a = str.toCharArray();
        int len = a.length;
        a[--len]++;
        while (a[len] > '9') {
            a[len] -= 10;
            a[--len]++;
        }
        System.out.println(a);
    }
}