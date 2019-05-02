package test;

import linkedList.LinkedListHelper;
import linkedList.ListNode;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode pHead1 = new ListNode(0);
        ListNode pHead1C = pHead1;
        ListNode pHead2 = new ListNode(0);
        ListNode pHead2C = pHead2;

        while (head != null) {
            ListNode node = head.next;
            if (head.val < x) {
                pHead1.next = head;
                pHead1 = pHead1.next;
            } else {
                pHead2.next = head;
                pHead2 = pHead2.next;
            }
            head.next = null;
            head = node;
        }

        if (pHead1C.next == null)
            return pHead2C.next;

        //pHead1C.next ... pHead1 === pHead1C.next
        pHead1.next = pHead2C.next;
        return pHead1C.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int k = 3;
        ListNode head = LinkedListHelper.create(nums);
        head = PartitionList.partition(head, k);
        LinkedListHelper.print(head);
    }
}
