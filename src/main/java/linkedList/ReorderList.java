package linkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // step 1 : find the mid of the list
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode head2 = p1.next;
        p1.next = null;

        // step 2 : reverse the second half
        p2 = head2.next;
        head2.next = null;
        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = head2;
            head2 = p2;
            p2 = temp;
        }
        // step 3 : merge the two sub list
        p1 = head;
        p2 = head2;
        while ( p1 != null) {
            ListNode t = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = t;
        }
        return;
    }
}