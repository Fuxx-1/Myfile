package com.study.E_Unsafe;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 20:55
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                hashMap.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(hashMap);
            }, String.valueOf(i)).start();
        }
    }
}
