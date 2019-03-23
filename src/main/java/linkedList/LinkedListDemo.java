package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

        while (queue.size() > 0) {
            System.out.println(queue.remove());
        }
    }
}
