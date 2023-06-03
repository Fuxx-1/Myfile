package ltd.newimg.sessioncookie.servlet;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    private static TestLock testLock = new TestLock();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        lock.readLock().lock();
        for (int i = 0; i < 20; i++) {
            add();
        }
        for (int i = 0; i < 5; i++) {
            read();
        }
    }

    private static void read() {
        new Thread(()-> {
            try {
                testLock.readlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "start!");
            System.out.println(num);
            System.out.println(Thread.currentThread().getName() + "over!");
            testLock.readunlock();
        }).start();
    }

    private static void add() {
        new Thread(()-> {
            try {
                testLock.writelock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "start!");
            System.out.println(num + "->" + ++num);
            System.out.println(Thread.currentThread().getName() + "over!");
            testLock.writeunlock();
        }).start();
    }
}
