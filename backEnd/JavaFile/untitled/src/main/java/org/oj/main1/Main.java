package org.oj.main1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // 输入字符串s
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int n = 0;
        for (int i : arr) {
            if (i != 0) n++;
        }
        if (n <= 1) {
            System.out.println(-1);
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            while (arr[++c % 26] == 0) ;
            sb.append((char)('a' + c % 26));
        }
        System.out.println(sb.toString());
    }
}

