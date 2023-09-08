package oj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), max = Integer.MIN_VALUE, res = 0;
        int toDel = m - n, min = Integer.MAX_VALUE;
        int[] nums = new int[m];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int temp = in.nextInt();
            nums[i] = temp;
            min = Math.min(temp, min);
            max = Math.max(temp, max);
            set.add(temp);
        }
        for (int i = 0; i < m; i++) {
            boolean hasResult = true;
            Set<Integer> resSet = new HashSet<>();
            while (hasResult) {
                int flag = 1, item = nums[i];
                for (int j = 2; item * j <= max; j++) {
                    if (set.contains(item * j) && !resSet.contains(item * j)) {
                        resSet.add(item * j);
                        item = item * j;
                        j = 2;
                        flag++;
                    }
                }
                if (flag >= toDel) {
                    res += flag - toDel + 1;
                } else {
                    hasResult = false;
                }
            }
        }
        System.out.println(res);
    }
}
