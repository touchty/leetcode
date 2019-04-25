package basics;

import java.util.Random;

public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }
    public static class MyRunnableII implements Runnable {

        private Integer threadLocal = 0;

        @Override
        public void run() {
           threadLocal = new Random().nextInt();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate

        // shared value!
        /*MyRunnableII sharedRunnableInstance = new MyRunnableII();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate*/
    }

}