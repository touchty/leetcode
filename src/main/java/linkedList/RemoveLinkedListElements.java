package linkedList;

/**
 * 203. Remove Linked List Elements
 * Easy
 * <p>
 * 663
 * <p>
 * 41
 * <p>
 * Favorite
 * <p>
 * Share
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        ListNode first = pseudoHead;
        ListNode next = head;
        while (next != null) {
            if (next.val != val) {
                first = next;
                next = next.next;
            } else {
                first.next = next.next;
                next = next.next;
                ;
            }
        }
        return pseudoHead.next;
    }
}
