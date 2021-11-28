import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @create: 2021-05-20 15:58
 **/
class ThreadFather {
    int id = 1;
    private int i = 5;

    public synchronized void Method() {
        for (int j = 0; j < 3; j++) {
            System.out.println("ThreadFather" + id + ":" + i--);
        }
    }
}

class MyThread_Thread extends Thread {
    private int i = 5;
    private int id = 1;

    public MyThread_Thread(int id) {
        this.id = id;
    }

    public synchronized void Method() {
        for (int j = 0; j < 3; j++) {
            System.out.println("MyThread_Thread" + id + ":" + i--);
        }
    }

    @Override
    public void run() {
        this.Method();
    }
}

class MyThread_Runnable extends ThreadFather implements Runnable {
    public MyThread_Runnable(int id) {
        super.id = id;
    }

    @Override
    public void run() {
        super.Method();
    }
}

class MyThread_callable extends ThreadFather implements Callable<Void> {
    public MyThread_callable(int id) {
        super.id = id;
    }

    @Override
    public Void call() throws Exception {
        super.Method();
        return null;
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        MyThread_Thread Thread1 = new MyThread_Thread(1);
//        new Thread(Thread1).start();
//        new Thread(Thread1).start();
//        MyThread_Runnable Thread2 = new MyThread_Runnable(2);
//        new Thread(Thread2).start();
//        new Thread(Thread2).start();
        int j = 5;
        Thread Thread4 = new Thread(() -> {
            System.out.println("jhfgd");
        });
        new Thread(Thread4).start();
        new Thread(Thread4).start();
        FutureTask<Void> Thread3 = new FutureTask<>(new MyThread_callable(3));
        new Thread(Thread3).start();
        new Thread(Thread3).start();
        new Thread(Thread3).start();
    }
}
