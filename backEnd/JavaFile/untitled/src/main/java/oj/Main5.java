package oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new HashMap<>();
            String s = sc.nextLine();
            char temp = '0';
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != temp) {
                    temp = s.charAt(j);
                    if (map.containsKey(s.charAt(j))) map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    else map.put(s.charAt(j), 1);
                }
            }
            int res = 0;
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                if (characterIntegerEntry.getValue() > n) {
                    res++;
                }
            }
            if (res == 0) System.out.println(1);
            else System.out.println(res);
        }
    }
}

