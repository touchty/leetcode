package basics.gc;

import java.lang.ref.*;

public class ReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> soft = new SoftReference<>(o1);

        Object o2 = new Object();
        WeakReference<Object> weak = new WeakReference<>(o2);

        Object o3 = new Object();
        WeakReference<String> weakString = new WeakReference<>("abc");

        Object o4 = new Object();
        PhantomReference<Object> phantom = new PhantomReference<>(o4, new ReferenceQueue<>());
        System.gc();
        System.out.println(soft.get());
        System.out.println(weak.get());
        System.out.println(weakString.get());
        System.out.println(phantom.get());
        System.out.println(o4.toString());
    }
}
