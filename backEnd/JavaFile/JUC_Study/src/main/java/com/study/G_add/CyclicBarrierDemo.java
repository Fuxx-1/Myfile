package com.study.G_add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 21:26
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /*
        集齐7颗龙珠召唤神龙
         */
        // 召唤龙珠的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤成功！！！");
        });

        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": 收集到了" + temp + "个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, String.valueOf(i)).start();
        }


    }
}
