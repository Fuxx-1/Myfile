package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Map<Integer, Integer> map = new Hashtable<>();
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
////            map.put(i, i);
//            int i1 = random.nextInt(1000);
//            System.out.println(i1);
//            map.put(i1, i1);
//        }
//        System.out.println("+++++++++");
//        for (Integer integer : map.keySet()) {
//            System.out.println(integer + ": " + map.get(integer));
//        }
//        System.out.println("+++++++++");
//        for (Integer integer : map.keySet()) {
//            System.out.println(integer + ": " + map.get(integer));
//        }
        int a = 0;
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5};
        res.add(new ArrayList<Integer>() {{
            add(nums[a]);
            add(nums[2]);
            add(nums[3]);
        }});
        System.out.println(res);
    }
}