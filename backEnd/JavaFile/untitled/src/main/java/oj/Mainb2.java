package oj;

import java.util.Scanner;

public class Mainb2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        for (int i = 0; i < time; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 1 && m == 1) System.out.println("No");
            else if ((n == 1 && m != 1) || (n != 1 && m == 1)) System.out.println("Yes");
            else {
                if (n % 2 == 1 && m % 2 == 0) System.out.println("Yes");
                else if ((n % 2 == 1 && m % 2 == 1) || (n % 2 == 0 && m % 2 == 0)) System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }
}
