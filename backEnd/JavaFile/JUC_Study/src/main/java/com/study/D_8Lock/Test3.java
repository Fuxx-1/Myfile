package com.study.D_8Lock;

import java.util.concurrent.TimeUnit;

/**
 * 5、增加两个静态的同步方法，只有一个对象，先打印发短信？打电话？
 * 6、两个对象！增加两个静态的同步方法，先打印发短信？打电话？
 * @author Eleun
 * @Description
 * @create 2022-10-24 16:09
 */
public class Test3 {
    public static void main(String[] args) {
        //两个对象的Class类模板只有一个，static,.锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

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

class Phone3 {

    // synchronized锁的对象是方法的调用者！
    // static静态方法
    // 类一加载就有了！锁的是Class
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sendSms...");
    }

    public static synchronized void call() {
        System.out.println("call...");
    }

}