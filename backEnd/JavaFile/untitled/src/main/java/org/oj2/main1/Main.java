package org.oj2.main1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }
        int max = Integer.MAX_VALUE, maxValue = 0, res = 0, farthest = Integer.MIN_VALUE, avg = (int) sum / n;
        for (Integer i : map.keySet()) {
            if (Math.abs(i - avg) < max) {
                max = Math.abs(i - avg);
                maxValue = i;
            }
        }
        for (Integer i : map.keySet()) {
            if (Math.abs(i - maxValue) > farthest) max = i;
        }
        for (Integer i : map.keySet()) {
            if (i == max) res += Math.abs(i - maxValue) * (map.get(i) - 1);
            else res += Math.abs(i - maxValue) * map.get(i);

        }
        if (max == maxValue) res++;
//        System.out.println(max + "|" + maxValue + "|" + res+ "|" + avg);
        System.out.println(res);
    }
}