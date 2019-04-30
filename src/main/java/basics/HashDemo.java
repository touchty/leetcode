package basics;

import java.util.HashMap;

public class HashDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, String> mapII = new HashMap<>(10);
        System.out.println(map.hashCode());
        System.out.println(mapII.hashCode());
        map.put(1, "first");
        map.get(1);
        Integer I = new Integer(10);
        Integer II = new Integer(20);
        Integer III = new Integer(10);
        System.out.println(I.equals(II));
        System.out.println(I.equals(III));

        Foo f1 = new Foo();
        f1.id = 1;
        Foo f2 = new Foo();
        f2.id = 2;
        System.out.println(f1.equals(f2));


        Bar b1 = new Bar();
        b1.id = 1;
        Bar b2 = new Bar();
        b2.id = 2;
        System.out.println(b1.equals(b2));
    }

    static class Foo {
        int id;

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof Foo) {
                Foo o = (Foo) obj;
                return this.id == o.id;
            }
            return false;
        }
    }

    static class Bar {
        int id;
        @Override
        public boolean equals(Object o) {
            return true;
        }
    }

}
