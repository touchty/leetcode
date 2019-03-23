package linkedList;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[4];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i);
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        ListNode head = nodes[0];
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        head = nodes[0];
        head = swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
