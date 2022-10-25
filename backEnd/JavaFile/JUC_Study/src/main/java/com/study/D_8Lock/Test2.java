package com.study.D_8Lock;

import java.util.concurrent.TimeUnit;

/**
 * 3、增加了一个普通方法后！先执行发短信还是hello?  普通方法
 * 4、两个对象，两个同步方法，发短信还是打电话？
 * @author Eleun
 * @Description
 * @create 2022-10-24 16:09
 */
public class Test2 {
    public static void main(String[] args) {
        // 两个对象
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone2 {

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

    // 这里没有锁！不是同步方法，不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}