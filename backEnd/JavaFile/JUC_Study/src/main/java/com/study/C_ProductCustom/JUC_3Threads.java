package com.study.C_ProductCustom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 10:55
 */
public class JUC_3Threads {

    public static void main(String[] args) {
        Resource3 resource3 = new Resource3();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    resource3.productA();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "P1").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    resource3.productB();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "P2").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    resource3.productC();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "P3").start();

    }
}

class Resource3 {
    // 属性
    private int number = 0;

    Lock lock = new ReentrantLock();
    private int semaphore = 1;

    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();


    public void productA() throws InterruptedException {
        try {
            lock.lock();
            while (semaphore != 1) {
                conditionA.await();
            }
            semaphore = 2;
            System.out.println("Consume 1");
//            System.out.println(Thread.currentThread().getName() + " " + 1 + "=>" + semaphore);
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void productB() throws InterruptedException {
        try {
            lock.lock();
            while (semaphore != 2) {
                conditionB.await();
            }
            semaphore = 3;
            System.out.println("Consume 2");
//            System.out.println(Thread.currentThread().getName() + " " + 2 + "=>" + semaphore);
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void productC() throws InterruptedException {
        try {
            lock.lock();
            while (semaphore != 3) {
                conditionC.await();
            }
            semaphore = 1;
            System.out.println("Consume 3\n");
//            System.out.println(Thread.currentThread().getName() + " " + 3 + "=>" + semaphore);
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

}
