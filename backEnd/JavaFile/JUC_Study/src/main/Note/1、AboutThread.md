# 什么是JUC

`java.util.concurrent`

在 `JDK 5.0` 提供了 `java.util.concurrent` (简称JUC)包,在此包中增加了在并发编程中很常用的工具类,
用于定义类似于线程的自定义子系统,包括线程池,异步 `IO` 和轻量级任务框架;还提供了设计用于多线程上下文中
的 `Collection` 实现等;

# 进程和线程

### 进程

是并发执行的程序在执行过程中分配和管理资源的基本单位，是一个动态概念，竞争计算机系统资源的基本单位。

### 线程

是进程的一个执行单元，是进程内科调度实体。比进程更小的独立运行的基本单位。线程也被称为轻量级进程。

### 协程

是一种比线程更加轻量级的存在。一个线程也可以拥有多个协程。其执行过程更类似于子例程，或者说不带返回值的函数调用。

## 查看 `CPU` 核数

```java
// CPU密集型、IO密集型
System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
```

## **并发和并行**

并发：两个或多个事件在 同一时间间隔 发生。 

并行：两个或者多个事件在 同一时刻 发生

### **`Java` 真的能开启线程吗？**

> 调用 `native`(本地) 的 `start0();` 方法开启线程，`Java `本身不能操作硬件

```java

public synchronized void start() {
    
    if (threadStatus != 0)
        throw new IllegalThreadStateException();

    group.add(this);

    boolean started = false;
    
    try {
        start0();
        // 调用本地方法
        started = true;
    } finally {
        try {
            if (!started) {
                group.threadStartFailed(this);
            }
        } catch (Throwable ignore) { }
    }
}
// 本地方法
private native void start0();
```

## 线程的状态

```java
System.out.println(Arrays.toString(Arrays.stream(Thread.State.values()).toArray()));
//[NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]
```

```java
public enum State {
    // 新生
    NEW,
    // 运行
    RUNNABLE,
    // 阻塞
    BLOCKED,
    // 等待
    WAITING,
    // 超时等待
    TIMED_WAITING,
    //终止
    TERMINATED;
}
```

## `wait()` 和 `sleep()`的区别

#### 1、来自不同的类

`wait()` 来自 `Object` 类

`sleep()` 来自 `Thread` 类

#### 2、关于锁的释放

`wait()` 会释放锁

`sleep()` 使线程休眠了，不会释放锁

