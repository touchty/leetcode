public class TTT {


    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        t1.start();
        System.out.println(Thread.activeCount());
        t2.start();
    }
}
class T extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}