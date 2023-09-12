package oj;

import java.util.*;

public class Mainb1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt(), flag = 0;
            sc.nextLine();
            String s = sc.nextLine();
            if (op == 1) {
                // 创建
                String[] s1 = s.split(" ");
                String name = s1[1].split("[(]")[0];
                String tmp = s.replaceAll(".+ .+\\(| .+,| .+\\)|\\)", "|");
                if (map.containsKey(name)) {
                    List<String> strings = map.get(name);
                    boolean yes = true;
                    for (int j = 0; j < strings.size(); j++) {
                        if (strings.get(j).equals(tmp)) {
                            System.out.println("method " + name + " is already defined.");
                            yes = false;
                        }
                    }
                    if (yes) {
                        map.get(name).add(tmp);
                        System.out.println("ok.");
                    }
                } else {
                    map.put(name, new ArrayList<String>() {{
                        add(tmp);
                    }});
                    System.out.println("ok.");
                }
            } else {
                // 调用
                String[] s2 = s.split("[(,)]");
                String a = s.replaceAll(".+\\(|,|\\)", "|");
                boolean yes = true;
                if (map.containsKey(s2[0])) {
                    for (String string : map.get(s2[0])) {
                        if (string.equals(a)) {
                            System.out.println("ok.");
                            yes = false;
                        }
                    }
                    if (yes) System.out.println("method " + s2[0] + " cannot be applied to given types.");
                } else {
                    System.out.println("cannot find symbol " + s2[0] + ".");
                }
            }
        }
    }
}
/*
7
1
int f(int x)
1
int g(int x,String s)
2
f()
1
void f(double x,double y)
2
f(double,double)
2
solve(int,String)
1
void f(int y)
*/