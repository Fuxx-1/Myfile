package com.study.C_ProductCustom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间的通信问题，生产者和消费者问题！ 等待唤醒和通知唤醒
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 *
 * @author Eleun
 * @Description
 * @create 2022-04-22 9:27
 */
public class JUC {
    public static void main(String[] args) {
        Resource2 resource2 = new Resource2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource2.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "P1").start();

        System.out.println("P1 started ...");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource2.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C1").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource2.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "P2").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource2.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C2").start();


    }
}

class Resource2 {
    // 属性
    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    // +1
    public void increment() throws InterruptedException {

        lock.lock();
        try {
            while (number != 0) {
                // 这里如果用 if 会造成虚假唤醒问题
                // 等待
                condition.await();
            }
            // 业务代码
            System.out.println(Thread.currentThread().getName() + "===>" + ++number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // -1
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                // 等待
                condition.await();
            }
            // 业务代码
            System.out.println(Thread.currentThread().getName() + "===>" + --number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
