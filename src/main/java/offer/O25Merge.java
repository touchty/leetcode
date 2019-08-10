package offer;

import linkedList.ListNode;

public class O25Merge {
    // recursive
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            ListNode head = list1;
            head.next = Merge(list1.next, list2);
            return head;
        } else {
            ListNode head = list2;
            head.next = Merge(list1, list2.next);
            return head;
        }
    }

    // iterative
    public ListNode MergeIter(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = new ListNode(list1.val);
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = new ListNode(list2.val);
                dummy = dummy.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            dummy.next = new ListNode(list1.val);
            dummy = dummy.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            dummy.next = new ListNode(list2.val);
            dummy = dummy.next;
            list2 = list2.next;
        }
        return newHead.next;
    }
}
