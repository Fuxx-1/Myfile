package com.study.F_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 21:01
 */
public class CallableTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<String> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": call...");
        return "callReturn...";
    }
}
