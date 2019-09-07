package basics.multiThreads;

public class FinalDemo {
    public FinalDemo() {
        foo = new Foo();
        f1 = foo;
    }

    public static class Foo {
        int i = 0;
    }


    final Foo foo;
    Foo f1;

    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo();
        finalDemo.f1.i = 100;
        System.out.println(finalDemo.f1.i);
    }
}
