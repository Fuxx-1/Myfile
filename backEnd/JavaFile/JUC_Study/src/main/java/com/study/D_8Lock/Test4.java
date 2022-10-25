package com.study.D_8Lock;

import java.util.concurrent.TimeUnit;

/**
 * 1、1个静态的同步方法，1个普通的同步方法，一个对象，先打印发短信？打电话？
 * 2、1个静态的同步方法，1个普通的同步方法，两个对象，先打印发短信？打电话？
 * @author Eleun
 * @Description
 * @create 2022-10-24 16:09
 */
public class Test4 {
    public static void main(String[] args) {
        //两个对象的Class类模板只有一个，static,.锁的是Class
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

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

class Phone4 {

    // 静态的同步方法锁的是Class类模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sendSms...");
    }

    // 普通的同步方法锁的调用者
    public synchronized void call() {
        System.out.println("call...");
    }

}