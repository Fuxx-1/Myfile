package org.oj.main4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入字符串的长度
        int n = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 输入字符串
        String string = scanner.nextLine();

        int minWeight = calculateMinWeight(string);
        System.out.println(minWeight);
    }

    public static int calculateMinWeight(String string) {
        int n = string.length();

        int minWeight = Integer.MAX_VALUE; // 最小连通块数量

        // 尝试不同的x和y取值
        for (int x = 1; x <= n; x++) {
            if (n % x == 0) {
                int y = n / x;
                int[][] matrix = new int[x][y]; // 矩阵，用于标记字符是否已访问

                int blocks = 0; // 连通块数量

                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        int index = i * y + j;
                        if (matrix[i][j] == 0) {
                            char c = string.charAt(index);
                            dfs(matrix, string, x, y, i, j, c);
                            blocks++;
                        }
                    }
                }

                minWeight = Math.min(minWeight, blocks);
            }
        }

        return minWeight;
    }

    public static void dfs(int[][] matrix, String string, int x, int y, int i, int j, char c) {
        if (i < 0 || i >= x || j < 0 || j >= y || matrix[i][j] != 0 || string.charAt(i * y + j) != c) {
            return;
        }

        matrix[i][j] = 1; // 标记字符已访问

        dfs(matrix, string, x, y, i - 1, j, c); // 上方
        dfs(matrix, string, x, y, i + 1, j, c); // 下方
        dfs(matrix, string, x, y, i, j - 1, c); // 左边
        dfs(matrix, string, x, y, i, j + 1, c); // 右边
    }
}