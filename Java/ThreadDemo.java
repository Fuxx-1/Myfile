import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        FutureTask<String> taskA = new FutureTask(mt);
        FutureTask<String> taskB = new FutureTask(mt);
        FutureTask<String> taskC = new FutureTask(mt);
        new Thread(taskA, "竞赛者A").start();
        new Thread(taskB, "竞赛者B").start();
        new Thread(taskC, "竞赛者C").start();
        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}

class MyThread implements Callable<String> {
    private boolean flag = false;          //抢到处理

    @Override
    public String call() throws Exception {
        synchronized (this) {                //数据同步
            if (this.flag == false) {        //抢答成功
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功!";
            } else {
                return Thread.currentThread().getName() + "抢答失败!";
            }
        }
    }
}