package offer;

import linkedList.ListNode;

public class O18_2DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode next = pHead.next;
        if (next.val == pHead.val) {
            while (next != null && next.val == pHead.val)
                next = next.next;
            return deleteDuplication(next);
        } else
            return pHead.next = deleteDuplication(next);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
    }
}
