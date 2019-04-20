package basics;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {
    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Orange extends Fruit {
    }


    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }

    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }

    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        //writeWithWildcard(apples, new Fruit());
        writeWithWildcard(fruit, new Apple());
        writeWithWildcard(fruit, new Fruit());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
