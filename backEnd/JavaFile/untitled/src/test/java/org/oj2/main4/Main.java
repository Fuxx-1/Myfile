package org.oj2.main4;

import java.util.Arrays;

public class Main {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Main().minMoves(new int[]{2, 2, 4, 5, 1, 2}));
    }
}