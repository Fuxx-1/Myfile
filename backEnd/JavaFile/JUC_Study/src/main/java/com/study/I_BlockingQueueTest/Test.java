package com.study.I_BlockingQueueTest;

import com.study.D_8Lock.Test1;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 22:14
 */
public class Test {
    public static void main(String[] args) {
        try {
            test4();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("a"));
        System.out.println(arrayBlockingQueue.add("b"));
        System.out.println(arrayBlockingQueue.add("c"));

        //ILLegalStateException:Queue full 抛出异常！
//        System.out.println(arrayBlockingQueue.add("d"));

        System.out.println("=====+++++=====");

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());


        // java.util.NoSuchElementException
//        System.out.println(arrayBlockingQueue.remove());

    }

    public static void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("a"));
        System.out.println(arrayBlockingQueue.offer("b"));
        System.out.println(arrayBlockingQueue.offer("c"));
        System.out.println(arrayBlockingQueue.offer("d")); // false
        System.out.println("=====+++++=====");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll()); // null
    }


    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("a");
        arrayBlockingQueue.put("b");
        arrayBlockingQueue.put("c");
        System.out.println(arrayBlockingQueue.take());
        arrayBlockingQueue.put("d");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("a", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("b", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("c", 2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("d", 2, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
    }
}
