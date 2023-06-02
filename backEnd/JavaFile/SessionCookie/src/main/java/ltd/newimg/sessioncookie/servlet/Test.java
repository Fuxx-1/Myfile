package ltd.newimg.sessioncookie.servlet;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

public class Test {
    private static TestLock testLock = new TestLock();
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            new Thread(()-> {
//                testLock.readlock();
//                System.out.println(Thread.currentThread().getName() + "start!");
//                System.out.println(num);
//                System.out.println(Thread.currentThread().getName() + "over!");
//                testLock.readunlock();
//            }).start();
//        }
        for (int i = 0; i < 5; i++) {
            new Thread(()-> {
                testLock.writelock();
                System.out.println(Thread.currentThread().getName() + "start!");
                System.out.println(num + "->" + ++num);
                System.out.println(Thread.currentThread().getName() + "over!");
                testLock.writeunlock();
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()-> {
                testLock.readlock();
                System.out.println(Thread.currentThread().getName() + "start!");
                System.out.println(num);
                System.out.println(Thread.currentThread().getName() + "over!");
                testLock.readunlock();
            }).start();
        }
    }
}
