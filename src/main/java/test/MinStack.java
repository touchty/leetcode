package test;

import java.util.*;

// LC 155. Min Stack
public class MinStack {

    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    static class MinStack2Stacks {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            dataStack.push(node);
            minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        int[] number = {1, 3, 5, 2, 4, 6};
        MinStack minStack = new MinStack();
        for (int n : number) {
            minStack.push(n);
        }
        List<Integer> list = new ArrayList<>(number.length);
        for (int i = 0; i < number.length; i++) {
            list.add(minStack.getMin());
            minStack.pop();
        }
        System.out.println(list);
    }
}
