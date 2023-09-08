package org.oj.main4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int maxHeight = dfs(tree, 1, 0);
        int answer;

        if (k >= maxHeight) {
            answer = n;
        } else {
            answer = 1 + Math.min(k + 1, maxHeight - k);
        }

        System.out.println(answer);
    }

    private static int dfs(List<List<Integer>> tree, int node, int parent) {
        int maxHeight = 0;

        for (int child : tree.get(node)) {
            if (child != parent) {
                int height = dfs(tree, child, node);
                maxHeight = Math.max(maxHeight, height);
            }
        }

        return maxHeight + 1;
    }
}