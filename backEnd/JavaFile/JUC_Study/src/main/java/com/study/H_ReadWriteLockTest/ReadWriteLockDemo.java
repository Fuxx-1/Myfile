package com.study.H_ReadWriteLockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 21:40
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(String.valueOf(temp), UUID.randomUUID().toString().substring(0, 5));
            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(myCache.get(String.valueOf(temp)));
            }, String.valueOf(i)).start();
        }

    }
}

/**
 *
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    //读写锁：更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //存，写入的时候，只希望同时只有一个线程写
    public void put(String key, Object object) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": " + key + ": 设置中");
            map.put(key, object);
            System.out.println(Thread.currentThread().getName() + ": " + key + ": 设置完毕");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    //取，读，所有人都可以读！
    public Object get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": " + key + ": 取出中");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + ": " + key + ": 取出完毕");
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}