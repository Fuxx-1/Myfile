package oj;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        sc.nextLine();
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < n; i++) strs[i] = sc.nextLine();
        Set<String> front = new HashSet<>(), end = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (j != strs[i].length() - 1) front.add(strs[i].substring(0, j + 1));
                if (j != 0) end.add(strs[i].substring(j, strs[i].length()));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (end.contains(strs[i].substring(0, j + 1)) && front.contains(strs[i].substring(j + 1, strs[i].length()))) {
                    res.add(strs[i]);
                    break;
                }
            }
        }
        System.out.println(res.size());
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

