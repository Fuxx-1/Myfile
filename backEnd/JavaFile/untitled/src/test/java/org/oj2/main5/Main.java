package org.oj2.main5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 项链上的珠子数量
        int k = sc.nextInt(); // 任意两个红色珠子的最小距离

        int[] beads = new int[n]; // 项链上的珠子，1表示红色，0表示白色

        for (int i = 0; i < 3; i++) {
            beads[sc.nextInt()] = 1;
        }

        int minSwaps = findMinSwaps(beads, k);
        System.out.println(minSwaps);
    }

    public static int findMinSwaps(int[] beads, int k) {
        int n = beads.length;
        int minSwaps = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int redBeads1 = 0;
            int redBeads2 = 0;

            for (int i = 0; i < n; i++) {
                if (i < start) {
                    redBeads1 += beads[i];
                } else {
                    redBeads2 += beads[i];
                }
            }

            int left = 0;
            int right = 0;
            int redCount = 0;

            while (right < n + start) {
                redCount += beads[right % n];

                if (right - left + 1 >= k) {
                    int minDistance = right - left + 1 - redCount;
                    if (minDistance >= k) {
                        minSwaps = Math.min(minSwaps, redBeads1 + redBeads2 - redCount);
                    }

                    redCount -= beads[left % n];
                    left++;
                }

                right++;
            }
        }

        return minSwaps;
    }
}