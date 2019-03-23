package array;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    current.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2 != null) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        return result.next;
    }

    ListNode mergeTwoListsOpt(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsOpt(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsOpt(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
