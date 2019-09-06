package test.multiThreads;

public class PrintThreeThreds {
    private static volatile Integer i = 1;
    static Object lock = new Object();

    public static class MyPrintTest extends Thread {
        int start = 0;

        public MyPrintTest(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            while (true) {
                if (i >= 75)
                    return;
                int index = i / 5;
                if ((index % 3 == start)) {
                    synchronized (lock) {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + (i++));
                        }
                    }
                }
            }
        }
    }

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (i >= 75)
                    return;
                int index = i / 5;
                if ((index % 3 == 0)) {
                    synchronized (lock) {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + (i++));
                        }
                    }
                }
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (i >= 75)
                    return;
                int index = i / 5;
                if ((index % 3 == 1)) {
                    synchronized (lock) {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + (i++));
                        }
                    }
                }
            }
        }
    });

    Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (i >= 75)
                    return;
                int index = i / 5;
                if ((index % 3 == 2)) {
                    synchronized (lock) {
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread().getName() + ":" + (i++));
                        }
                    }
                }
            }
        }
    });

    public static void main(String[] args) {
        /*PrintThreeThreds solution = new PrintThreeThreds();
        solution.t1.start();
        solution.t2.start();
        solution.t3.start();*/

        MyPrintTest task0 = new PrintThreeThreds.MyPrintTest(0);
        MyPrintTest task1 = new PrintThreeThreds.MyPrintTest(1);
        MyPrintTest task2 = new PrintThreeThreds.MyPrintTest(2);
        task0.start();
        task1.start();
        task2.start();
    }
}
