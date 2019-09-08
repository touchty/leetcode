package basics.multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new MyRunnable(i));
        }
        executorService.shutdown();
        //executorService.shutdownNow();
    }

    static class MyRunnable implements Runnable {
        int id;

        MyRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("threadpool" + " task id:" + id
                        + " is running threadInfo:" + Thread.currentThread().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
