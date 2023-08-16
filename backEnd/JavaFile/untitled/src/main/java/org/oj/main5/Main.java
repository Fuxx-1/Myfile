package org.oj.main5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int coinChange(int[] coins, int[] counts, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    minCoins = Math.min(minCoins, dp[i - coins[j]] + counts[j]);
                }
            }
            dp[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int n = 10;
        List<Integer>[] list = new ArrayList[n + 1];
        list[0] = new ArrayList<Integer>() {{
            add(1);
        }};
        System.out.println(list[0]);
    }
}