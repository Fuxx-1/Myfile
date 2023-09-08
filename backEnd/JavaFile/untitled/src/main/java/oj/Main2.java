package oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        if (contains(board, n, m)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static boolean contains(char[][] board, int n, int m) {
        List<HashSet<Character>> list = new ArrayList<>();
        for (char[] c : board) {
            HashSet<Character> set = new HashSet<>();
            for (char ch : c) {
                set.add(ch);
            }
            list.add(set);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains('m')) {
                sb.append("m");
            } else if (list.get(i).contains('e') && sb.toString().equals("m")) {
                sb.append("e");
            } else if (list.get(i).contains('i') && sb.toString().equals("me")) {
                sb.append("i");
            } else if (list.get(i).contains('t') && sb.toString().equals("mei")) {
                sb.append("t");
            } else if (list.get(i).contains('u') && sb.toString().equals("meit")) {
                sb.append("u");
            } else if (list.get(i).contains('a') && sb.toString().equals("meitu")) {
                sb.append("a");
            } else if (list.get(i).contains('n') && sb.toString().equals("meitua")) {
                sb.append("n");
            }
        }
        return sb.toString().equals("meituan");
    }
}
