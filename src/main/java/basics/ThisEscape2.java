package basics;

/**
 * 模拟this逃逸2：构造器中启动线程
 *
 * @author Lijian
 */
public class ThisEscape2 {
    final int i;
    int j;

    public ThisEscape2() throws InterruptedException {
        new Thread(new RunablTest()).start();
        Thread.sleep(2000);
        i = 1;
        j = 1;
    }

    //内部类实现Runnable：引用外部类
    private class RunablTest implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(ThisEscape2.this.j);
            } catch (NullPointerException e) {
                System.out.println("发生空指针错误：普通变量j未被初始化");
            }
            try {
                System.out.println(ThisEscape2.this.i);
            } catch (NullPointerException e) {
                System.out.println("发生空指针错误：final变量i未被初始化");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ThisEscape2();
    }
}