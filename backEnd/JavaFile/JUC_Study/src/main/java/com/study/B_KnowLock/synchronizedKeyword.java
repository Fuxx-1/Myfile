package com.study.B_KnowLock;

/**
 * @author Eleun
 * @Description
 * @create 2022-04-21 22:29
 * 真正的多线程开发，公司中的方法，降低耦合性
 * 线程就是一个单独的资源类，没有任何附属的操作
 * 1、属性
 * 2、方法
 */
public class SynchronizedKeyword {
    public static void main(String[] args) {
//        new Thread(new MyThread()).start();
        // 传统方法
        Ticket ticket = new Ticket();
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

// 常规方法
class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

//资源类 OOP编程
class Ticket {
    // 属性
    private int number = 50;

    // 方法
    // synchronized 本质：队列，锁。
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "张票，剩余" + number);
        }
    }
}