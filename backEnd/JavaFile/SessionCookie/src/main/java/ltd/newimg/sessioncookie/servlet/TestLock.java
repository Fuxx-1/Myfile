package ltd.newimg.sessioncookie.servlet;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {


    private volatile int readCount = 0;
    private Lock countLock = new ReentrantLock();
    private Lock writeLock = new ReentrantLock();


    public void readlock() {
        synchronized (TestLock.class) {
            countLock.lock();
            if (readCount == 0) writelock();
            readCount += 1;
            countLock.unlock();
        }
    }

    public void readunlock() {
        synchronized (TestLock.class) {
            countLock.lock();
            readCount--;
            if (readCount == 0) writeunlock();
            countLock.unlock();
        }
    }


    public void writelock() {
        writeLock.lock();
    }

    public void writeunlock() {
        writeLock.unlock();
    }

}
