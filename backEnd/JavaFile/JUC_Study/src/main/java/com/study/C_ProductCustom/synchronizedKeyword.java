package com.study.C_ProductCustom;

/**
 * 线程间的通信问题，生产者和消费者问题！ 等待唤醒和通知唤醒
 * 线程交替执行 A B 操作同一个变量 num = 0
 * A num + 1
 * B num - 1
 * @author Eleun
 * @Description
 * @create 2022-04-22 9:27
 */
public class SynchronizedKeyword {
    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        resource.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        resource.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        resource.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        resource.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "D").start();
    }
}

class Resource {
    // 属性
    private int number = 0;

    // +1
    public synchronized void increment() throws InterruptedException {

        while (number != 0) {
            // 这里如果用 if 会造成虚假唤醒问题
            // 等待
            this.wait();
        }
        // 业务代码
        System.out.println(Thread.currentThread().getName() + "===>" + ++number);
        // 通知其他线程
        this.notifyAll();
    }

    // -1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            // 等待
            this.wait();
        }
        // 业务代码
        System.out.println(Thread.currentThread().getName() + "===>" + --number);
        // 通知其他线程
        this.notifyAll();
    }
}
