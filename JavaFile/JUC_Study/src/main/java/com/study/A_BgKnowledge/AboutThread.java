package com.study.A_BgKnowledge;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class AboutThread {
    public static void main(String[] args) {
//        concurrent
        new Thread().start();
        // CPU密集型、IO密集型
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
        /**
         * 并发：两个或多个事件在 同一时间间隔 发生。
         * 并行：两个或者多个事件在 同一时刻 发生
         */
        // 线程的状态：Thread.State
        // [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]
        System.out.println(Arrays.toString(Arrays.stream(Thread.State.values()).toArray()));

    }

//
//    // 以下为 Thread().start() 部分的源码
//

    /**
     * Causes this thread to begin execution; the Java Virtual Machine
     * calls the <code>run</code> method of this thread.
     * <p>
     * The result is that two threads are running concurrently: the
     * current thread (which returns from the call to the
     * <code>start</code> method) and the other thread (which executes its
     * <code>run</code> method).
     * <p>
     * It is never legal to start a thread more than once.
     * In particular, a thread may not be restarted once it has completed
     * execution.
     *
     * @throws IllegalThreadStateException if the thread was already
     *                                     started.
     * @see #run()
     * @see #stop()
     */
    public synchronized void start() {
//        /**
//         * 不会为由 VM 创建的主方法线程或“系统”组线程调用此方法。
//         * 将来添加到此方法的任何新功能也可能必须添加到 VM。
//         * 零状态值对应于状态“NEW”。
//         */
//        if (threadStatus != 0) {
//            throw new IllegalThreadStateException();
//        }
//
//        /*
//        通知组此线程即将启动，以便将其添加到组的线程列表中，并且可以递减组的未启动计数。
//         */
//        group.add(this);
//
//        boolean started = false;
//        try {
//            // 调用 native(本地) 方法开启线程，Java 本身不能操作硬件
//            start0();
//            started = true;
//        } finally {
//            try {
//                if (!started) {
//                    group.threadStartFailed(this);
//                }
//            } catch (Throwable ignore) {
//                /* 没做什么。如果 start0() 抛出一个 Throwable 那么它将被传递到调用堆栈 */
//            }
//        }
    }
//
//    private native void start0();

}

