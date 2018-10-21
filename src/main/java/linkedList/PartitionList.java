package linkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0); // less
        ListNode ge = new ListNode(0); // greater or equal
        ListNode dummyLess = less; // head
        ListNode dummyGe  = ge; // head

        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                less.next = head;
                less = less.next;
            }
            else {
                ge.next = head;
                ge = ge.next;
            }
            head.next = null;
            head = next;
        }

        less.next = dummyGe.next;

        return dummyLess.next;
    }
}
