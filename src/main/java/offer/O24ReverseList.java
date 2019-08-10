package offer;

import linkedList.LinkedListHelper;
import linkedList.ListNode;

public class O24ReverseList {
    // recursive
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next);

        // next 将成为新的尾部，所以一要把head 添加到next的尾部
        next.next = head;
        return newHead;
    }

    // iterable
    public static ListNode ReverseListIter(ListNode head) {
        ListNode dummyH = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummyH;
            dummyH = head;
            head = next;
        }
        return dummyH;
    }

    public static void main(String[] args) {
        int[] origin = {1, 2, 3};
        ListNode root = LinkedListHelper.create(origin);
        root = O24ReverseList.ReverseListIter(root);
        LinkedListHelper.print(root);
    }
}
