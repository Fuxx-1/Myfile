package org.test;

import java.util.concurrent.TimeUnit;

public class MutiTest {
    public static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    a++;
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(a);
    }
}
