package concurrentDemo;

public class TinyThread extends Thread{
    VolatileDemo v;
    public TinyThread(VolatileDemo v) {
        this.v = v;
    }
    @Override
    public void run(){
        synchronized (v) {
            v.count = v.count + 1;
        }
    }
}