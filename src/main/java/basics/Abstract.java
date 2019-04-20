package basics;

import java.util.LinkedList;
import java.util.List;

abstract class A {
    static int i = 1;

    static String name() {
        return "hello";
    }
}

class Aimpl extends A {

}

public class Abstract {
    public static void main(String[] args) {
        Aimpl a = new Aimpl();
        System.out.println(a.i);
        System.out.println(a.name());

        // is-a like-a
        List<Integer> l = new LinkedList<>();
    }
}
