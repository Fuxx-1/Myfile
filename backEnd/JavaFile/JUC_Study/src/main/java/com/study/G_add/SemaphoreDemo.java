package com.study.G_add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 21:32
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + "离开了车位");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
