package basics.concurrentDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            //executorService.execute(new MyRunnable());
            executorService.submit(new MyRunnable());
        }
        executorService.shutdown();
    }
}
