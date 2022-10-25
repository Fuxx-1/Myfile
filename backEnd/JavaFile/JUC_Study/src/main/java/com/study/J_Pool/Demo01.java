package com.study.J_Pool;


import java.util.concurrent.*;

/**
 * @author Eleun
 * @Description
 * @create 2022-10-24 22:47
 */
public class Demo01 {
    public static void main(String[] args) {
        /*
          new ThreadPooLExecutor.AbortPolicy()          //银行满了，还有人进来，不处理这个人的，抛出异常
          new ThreadPooLExecutor.CallerRunsPolicy()     //哪来的去哪里！
          new ThreadPooLExecutor.DiscardPolicy()        //队列满了，丢掉任务，不会抛出异常！
          new ThreadPooLExecutor.DiscardOldestPolicy()  //队列满了，尝试去和最早的竞争，也不会抛出异常！
        */
        /*
        最大线程到底该如何定义
        1、CPU密集型，几核，就是几，可以保持CPU的效率最高！
        2、IO密集型  >  判断你程序中十分耗IO的线程，
        程序  15个大型任务io十分占用资源！
        */
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可伸缩的，遇强则强，遇弱则弱
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 1; i <= 15; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }
    }
}


/*

    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

    public ThreadPoolExecutor(int corePoolSize,                         // 核心线程池大小
                              int maximumPoolSize,                      // 最大核心线程池大小
                              long keepAliveTime,                       // 超时了没有人调用就会释放
                              TimeUnit unit,                            // 超时单位
                              BlockingQueue<Runnable> workQueue,        // 阻塞队列
                              ThreadFactory threadFactory,              // 线程工厂：创建线程的，一般不用动
                              RejectedExecutionHandler handler) {       // 拒绝策略
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.acc = System.getSecurityManager() == null ?
                null :
                AccessController.getContext();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
 */
