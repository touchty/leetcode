package basics.concurrentDemo;

public class InterruptExample {
    private static class MyThread1 extends Thread {
        @Override
        synchronized public void run() {
            try {
                wait();
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }
}
