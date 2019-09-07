package basics.multiThreads;

public class InterruptExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                boolean interrupted = interrupted();
                if (interrupted) {
                    System.out.println("This thread is interrupted. Have to return.");
                    return;
                } else {
                    System.out.println("Doing task.");
                }
            }
        }
    }

    private static class Foo {
        synchronized public void foo() throws InterruptedException {
            while (true) {
                System.out.println("foo");
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");*/
    }
}