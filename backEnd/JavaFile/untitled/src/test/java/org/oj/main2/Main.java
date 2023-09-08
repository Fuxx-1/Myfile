package org.oj.main2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ints = new int[n][10];
        int[] num = new int[n];
        if (n == 0) {
            System.out.println("0 0 0 0 0 0 0 0 0 0");
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        ints[n - 1][num[n - 1]] = 1;
        for (int i = n - 2; i >= 0 ; i--) {
            for (int j = 0; j < 10; j++) {
                ints[i][(num[i] * j) % 10] += ints[i + 1][j];
                ints[i][(num[i] + j) % 10] += ints[i + 1][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(ints[0][i] + " ");
        }
    }
}

