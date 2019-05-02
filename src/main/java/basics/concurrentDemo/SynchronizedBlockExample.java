package basics.concurrentDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBlockExample {
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedBlockExample e1 = new SynchronizedBlockExample();
        SynchronizedBlockExample e2 = new SynchronizedBlockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        //executorService.shutdown();
    }
}
