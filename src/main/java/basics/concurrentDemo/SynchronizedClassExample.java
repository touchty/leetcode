package basics.concurrentDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedClassExample {
    public void func2() {
        synchronized (SynchronizedClassExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedClassExample e1 = new SynchronizedClassExample();
        SynchronizedClassExample e2 = new SynchronizedClassExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
        Integer I = new Integer(1);
        try {
            I.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
