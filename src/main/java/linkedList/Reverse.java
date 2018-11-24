package linkedList;

public class Reverse {
    public static ListNode reversed(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;

        while(p != null) {
            ListNode temp = p.next;
            p.next = head;
            head = p;
            p = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int len = 10;
        ListNode[] nodes = new ListNode[len];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i + 1);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i+1];
        }

        ListNode head = null;
        if (nodes.length >= 1)
            head = nodes[0];
        head = reversed(head);
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }
}
