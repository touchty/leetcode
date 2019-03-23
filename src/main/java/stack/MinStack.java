package stack;

class MinStack {
    private Integer[] array;
    private int len = 0;
    private int capacity = 20;
    private int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        array = new Integer[capacity];
    }

    public void push(int x) {
        if (len < capacity) {
            array[len++] = x;
        } else {
            capacity = 2 * capacity + 1;
            Integer[] arrayExtended = new Integer[capacity];
            for (int i = 0; i < len; i++) {
                arrayExtended[i] = array[i];
            }
            array = arrayExtended;
            array[len++] = x;
        }
        min = Math.min(min, x);
    }

    public void pop() {
        if (len <= 0)
            len = 0;
        else {
            len--;
            if (min == array[len]) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < len; i++) {
                    min = Math.min(min, array[i]);
                }
            }
        }

    }

    public Integer top() {
        if (len <= 0)
            return null;
        else
            return array[len - 1];
    }

    public Integer getMin() {
        if (len > 0) {
            return min;
        } else
            return null;
    }

    class MinStackOpt {
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
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //--> Returns -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        //--> Returns 0.
        System.out.println(minStack.top());
        //--> Returns -2.
        System.out.println(minStack.getMin());
    }
}