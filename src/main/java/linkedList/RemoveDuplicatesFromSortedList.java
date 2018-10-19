package linkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = slow.next;

        while(fast != null) {
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            slow.next = fast;
            if (fast == null)
                break;
            slow = fast;
            fast = fast.next;
        }

        return head;
    }
}
