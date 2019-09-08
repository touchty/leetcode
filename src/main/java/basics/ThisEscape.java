package basics;

/**
 * 模拟this逃逸
 *
 * @author Lijian
 */
public class ThisEscape {
    //final常量会保证在构造器内完成初始化（但是仅限于未发送this逃逸的情况下）
    final int i;
    //尽管实例变量有初始值，但是还实例化完成
    int j = 0;
    static ThisEscape obj;

    public ThisEscape() throws InterruptedException {
        Thread.sleep(2000);
        i = 1;
        j = 1;
        //obj = new ThisEscape();
    }

    public static void main(String[] args) {
        //线程A：模拟构造器中this逃逸,将未构造完全对象引用抛出
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //构造初始化中...线程B可能获取到还未被初始化完成的变量
                //类似于this逃逸，但并不定发生
                try {
                    obj = new ThisEscape();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //线程B：读取对象引用，访问i/j变量
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //可能会发生初始化失败的情况解释：实例变量i的初始化被重排序到构造器外，此时1还未被初始化
                ThisEscape objB = obj;
                try {
                    System.out.println(objB.j);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：普通变量j未被初始化");
                }
                try {
                    System.out.println(objB.i);
                } catch (NullPointerException e) {
                    System.out.println("发生空指针错误：final变量i未被初始化");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}