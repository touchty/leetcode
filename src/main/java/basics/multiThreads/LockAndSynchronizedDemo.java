package basics.multiThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndSynchronizedDemo {
    Lock lock = new ReentrantLock();

    void foo() {
        lock.lock();
        System.out.println("locked!");
        lock.unlock();
        System.out.println("unlock");
    }

    void fooTryLock() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "得到了锁");
                for (int i = 0; i < 5; i++) {
                    System.out.println("doing");
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        }
    }

    synchronized void fooSynchronized() throws InterruptedException {
        wait();
    }

    public static void main(String[] args) {
        LockAndSynchronizedDemo solution = new LockAndSynchronizedDemo();
        solution.foo();
        solution.fooTryLock();
    }
}
