package com.study.B_KnowLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 真正的多线程开发，公司中的方法，降低耦合性
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1、属性
 * 2、方法
 * @author Eleun
 * @Description
 * @create 2022-04-21 22:29
 */
public class LockUseDemo {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        // @FunctionalInterface 函数式接口 ==> jdk1.8 lambda表达式 (参数)->{代码}
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();
        // 并发，多线程操作同一个资源类，把资源类丢入线程
    }
}


//资源类 OOP编程
class Ticket2 {
    // 属性
    private int number = 50;

    Lock lock = new ReentrantLock();

    // 方法
    // Lock 本质：队列，锁。
    public void sale() {
        lock.lock();
        // 获取锁
        try {
            // 业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "张票，剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            // 释放锁
        }
    }
}