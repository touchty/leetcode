package linkedList;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // length of the list
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        // empty list
        if (count == 0)
            return head;
        k %= count;
        for (int i = 0; i < k; i++) {
            head = roteOneStepR(head);
        }
        return head;
    }

    /**
     * shift a step right
     *
     * @param head head of the list
     * @return ListNode head shifting a step right
     */
    ListNode roteOneStepR(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tailLeft = head;
        ListNode tail = head.next;
        while (tail.next != null) {
            tailLeft = tailLeft.next;
            tail = tail.next;
        }
        tailLeft.next = null;
        tail.next = head;
        return tail; // tail now is the head.
    }
}
