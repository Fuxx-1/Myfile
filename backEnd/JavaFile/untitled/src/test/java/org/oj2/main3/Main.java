package org.oj2.main3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int max = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (String str : split) {
            if (str.contains(":")) {
                String[] spl = str.split(":");
                int a = Integer.parseInt(spl[0]), b = Integer.parseInt(spl[1]);
                if (!map.containsKey(b)) {
                    max = Math.max(max, b);
                    map.put(b, new ArrayList<Integer>() {{
                        add(a);
                    }});
                } else {
                    map.get(b).add(a);
                }
            }
        }
        int res = max;
        int temp = 0;
        for (int i = 0; i < max; i++) {
            if (map.containsKey(i)) {
                List<Integer> integers = map.get(i);
                int sum = 0, min = Integer.MAX_VALUE;
                for (Integer integer : integers) {
                    sum += integer;
                    min = Math.min(min, integer);
                }
                if (res >= i + sum - min) {
                    res -= sum;
                } else {
                    if (res >= i) {
                        temp += i - res;
                    }
                    if (min != sum) {
                        temp += min;
                    }
                    res = i - min;
                }
            }
        }
        if (max + temp > 4800) {
            System.out.println(-1);
            System.exit(1);
        }
        System.out.println(max);
        System.out.println(max + temp);
    }
}


