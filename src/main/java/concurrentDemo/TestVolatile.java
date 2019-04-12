package concurrentDemo;

public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        VolatileDemo v = new VolatileDemo();
        Thread t1 = new TinyThread(v);
        Thread t2 = new TinyThread(v);
        Thread t3 = new TinyThread(v);
        Thread t4 = new TinyThread(v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        int realCount = v.count;
        int expected = 4;
        System.out.println(realCount);
        System.out.println("expected: " + expected);
    }
}
