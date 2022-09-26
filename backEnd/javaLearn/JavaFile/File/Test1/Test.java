/**
 * @create: 2021-05-20 19:06
 **/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("输入n - 1");
        int[] a = new int[Sc.nextInt()];
        System.out.println("依次输入数组的值");
        for (int i = 0; i < a.length; i++) {
            a[i] = Sc.nextInt();
        }
        System.out.println("输入first");
        int[] b = new int[a.length + 1];
        b[0] = Sc.nextInt();
        int temp1, temp2;
        for (int i = 1; i < b.length; i++) {
            temp1 = b[i - 1];
            temp2 = a[i - 1];
            for (int j = 1; temp1 != 0 || temp2 != 0; j *= 2) {
                if (temp1 % 2 == 0 && temp2 % 2 == 1 || temp2 % 2 == 0 && temp1 % 2 == 1) {
                    b[i] += j;
                }
                temp1 = temp1 / 2;
                temp2 = temp2 / 2;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
