package test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // queue
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        while(!deque.isEmpty()) {
            System.out.println(deque.getFirst());
            deque.removeFirst();
        }

        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        while(!deque.isEmpty()) {
            System.out.println(deque.poll());
        }

        // stack

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        while(!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
