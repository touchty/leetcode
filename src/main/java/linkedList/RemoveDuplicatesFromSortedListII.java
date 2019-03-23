package linkedList;

public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode foo = new ListNode(0);
        ListNode p = foo;
        ListNode slow = head;
        ListNode fast = slow;

        while (slow != null) {
            while (fast != null) {
                if (fast.val == slow.val) {
                    fast = fast.next;
                } else {
                    break;
                }
            }

            if (slow.next == fast) {
                p.next = slow;
                p = p.next;
                p.next = null; // Attention!
            }
            /*if (p.next != null)
                p = p.next;*/

            slow = fast;

        }
        return foo.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode res = RemoveDuplicatesFromSortedListII.deleteDuplicates(n1);

    }
}
