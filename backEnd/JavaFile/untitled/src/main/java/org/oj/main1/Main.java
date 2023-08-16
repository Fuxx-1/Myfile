package org.oj.main1;

import java.util.Scanner;

public class Main {
    static double p = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextDouble();
        System.out.println(recursion(1, 1) * 1.5);
    }

    public static double recursion(int time, double np) {
        if (time == 90) return np * 90;
        double newNp = np * (1 - p);
        return recursion(time + 1, newNp) + time * p * np;
    }
}