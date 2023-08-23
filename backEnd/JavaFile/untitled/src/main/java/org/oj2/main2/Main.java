package org.oj2.main2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<Integer, Integer> mapS = new HashMap<>();
        Map<Integer, Integer> mapH = new HashMap<>();
        Map<Integer, Integer> mapD = new HashMap<>();
        Map<Integer, Integer> mapC = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            int sum = in.nextInt();
            String s = in.nextLine();
            if (s.charAt(1) == 'S') mapS.put(num, sum);
            if (s.charAt(1) == 'H') mapH.put(num, sum);
            if (s.charAt(1) == 'D') mapD.put(num, sum);
            if (s.charAt(1) == 'C') mapC.put(num, sum);
        }
        int res = 0;
        res += func(mapS);
        res += func(mapH);
        res += func(mapD);
        res += func(mapC);
        System.out.println(res);
    }

    private static int func(Map<Integer, Integer> map) {
        int res = 0;
        for (Integer i : map.keySet()) {
            if (map.containsKey(i) && map.containsKey(i + 1) && map.containsKey(i + 2) && map.containsKey(i + 3) && map.containsKey(i + 4)) {
                int min = FindMin(map.get(i), map.get(i + 1), map.get(i + 2), map.get(i + 3), map.get(i + 4));
                res += min;
                map.put(i, map.get(i) - min);
                map.put(i + 1, map.get(i + 1) - min);
                map.put(i + 2, map.get(i + 2) - min);
                map.put(i + 3, map.get(i + 3) - min);
                map.put(i + 4, map.get(i + 4) - min);
            } else {
                continue;
            }
        }
        return res;
    }

    public static int FindMin(int a, int b, int c, int d, int f) {
        int min = Integer.MAX_VALUE;
        min = Math.min(min, a);
        min = Math.min(min, b);
        min = Math.min(min, c);
        min = Math.min(min, d);
        min = Math.min(min, f);
        return min;
    }
}