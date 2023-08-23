package org.oj2.main3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- != 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(),
                    d = sc.nextInt(), e = sc.nextInt();
            if (b * 3 > a) {
                System.out.println(-1);
                System.exit(0);
            }
            int f = d - c;
            int g = e - d;
            if (f + g > b * 2) {
                System.out.println(b - Math.min(f, g));
            } else {
                int res = 0;
                if (f < b)  res += Math.abs(b - f);
                if (g < b)  res += Math.abs(b - g);
                System.out.println(res);
            }
        }
    }
}


