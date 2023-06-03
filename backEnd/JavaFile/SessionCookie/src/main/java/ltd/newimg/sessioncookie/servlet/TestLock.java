package ltd.newimg.sessioncookie.servlet;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {


    private volatile int readCount = 0;
    private Lock countLock = new ReentrantLock();
    private Semaphore writeLock = new Semaphore(1);


    public void readlock() throws InterruptedException {
        countLock.lock();
        if (readCount == 0) writelock();
        readCount += 1;
        countLock.unlock();
    }

    public void readunlock() {
        countLock.lock();
        readCount--;
        if (readCount == 0) writeunlock();
        countLock.unlock();
    }


    public void writelock() throws InterruptedException {
        writeLock.acquire();
    }

    public void writeunlock() {
        writeLock.release();
    }

}
