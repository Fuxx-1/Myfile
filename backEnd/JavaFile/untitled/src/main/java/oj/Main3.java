package oj;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long len = in.nextLong(), max = Integer.MIN_VALUE, maxTime = 0, first = 0, res = 0, secmax = 0;
        long[] nums = new long[(int) len];
        for (long i = 0; i < len; i++) {
            nums[(int) i] = in.nextLong();
            if (nums[(int) i] == max) {
                maxTime++;
            } else if (max < nums[(int) i]) {
                maxTime = 1;
                secmax = max;
                max = nums[(int) i];
            }
        }
        if (nums[0] > max) {
            System.out.println(0);
        } else if (nums[0] == 0) {
            for (int i = 0; i < len; i++) {
                while (nums[i] != 0) {
                    nums[i] /= 2;
                    res += 1;
                }
            }
            System.out.println(res);
        } else {
            if (maxTime == 1 && max % 2 == 1 && secmax * 2 < max) {
                max = max / 2;
                res += 1;
            }
            while (nums[0] < max) {
                nums[0] *= 2;
                res += 1;
            }
            System.out.println(res);
        }
    }
}
