package basics.gc;

import java.lang.ref.*;

public class ReferenceDemo {
    public static void main(String[] args) {
        SoftReference<Object> soft = new SoftReference<>(new Object());
        WeakReference<Object> weak = new WeakReference<>(new Object());
        WeakReference<String> weakString = new WeakReference<>("abc");
        PhantomReference<Object> phantom = new PhantomReference<>(new Object(), new ReferenceQueue<>());
        System.gc();
        System.out.println(soft.get());
        System.out.println(weak.get());
        System.out.println(weakString.get());
        System.out.println(phantom.get());
    }
}
