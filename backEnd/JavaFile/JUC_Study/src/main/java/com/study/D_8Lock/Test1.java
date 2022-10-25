package com.study.D_8Lock;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个间题
 * 1、标准情况下，两个线程先打印发短信还是打电话？1/发短信 2/打电话
 * 2、sendSms,延迟4秒，两个线程先打印发短信还是打电话？1/发短信 2/打电话
 *
 * @author Eleun
 * @Description
 * @create 2022-10-24 16:09
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            phone.call();
        }, "B").start();
    }
}

class Phone {

    // synchronized锁的对象是方法的调用者！
    // 两个方法用的是同一个锁，谁先拿到谁执行！
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sendSms...");
    }

    public synchronized void call() {
        System.out.println("call...");
    }
}