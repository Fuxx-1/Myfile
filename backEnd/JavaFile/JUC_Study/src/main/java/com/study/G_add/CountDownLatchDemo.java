package com.study.G_add;

import java.util.concurrent.CountDownLatch;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 21:21
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": Go out");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await(); // 等到countDownLatch归零
        System.out.println("Close door!");
//        countDownLatch.countDown(); // -1
    }
}

