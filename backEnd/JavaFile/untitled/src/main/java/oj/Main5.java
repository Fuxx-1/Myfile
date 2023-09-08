package oj;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), res = 0;
        int[] nums = new int[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
            if (i == 0) {
                map.put(nums[i], new ArrayList<Integer>() {{
                    add(1);
                }});
            } else {
                res = 0;
                for (int j = 1; j <= nums[i]; j++) {
                    if (nums[i] % j == 0) {
                        List<Integer> integers = map.get(nums[i] / j);
                        if (integers != null) {
                            for (Integer integer : integers) {
                                res += integer;
                            }
                        }
                    }
                }
                if (map.containsKey(nums[i])) {
                    map.get(nums[i]).add(res);
                } else {
                    int finalRes = res;
                    map.put(nums[i], new ArrayList<Integer>() {{
                        add(finalRes);
                    }});
                }
            }
        }
        System.out.println(res);
    }
}
