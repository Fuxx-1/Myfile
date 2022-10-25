package com.study.I_BlockingQueueTest;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 22:37
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + ": put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + ": put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "->" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "->" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "->" + synchronousQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T2").start();
    }
}
