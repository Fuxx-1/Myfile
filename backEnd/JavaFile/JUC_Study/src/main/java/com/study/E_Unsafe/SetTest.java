package com.study.E_Unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 16:59
 */
// ConcurrentModificationException 并发修改异常！

public class SetTest {
    public static void main(String[] args) {
        //Set<String>set = new Hashset<>();
        //Set<String>set = Collections.synchronizedset(new Hashset<>());
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
