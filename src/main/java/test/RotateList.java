package test;

import pq.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        // 检查初始值
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode t = head;
        while (t != null) {
            len++;
            t = t.next;
        }

        k = k % len;

        if (k == 0) return head; // 退出条件
        ListNode prev = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            prev = prev.next;
        }

        ListNode pHead = prev.next;
        prev.next = null;
        fast.next = head;
        return pHead;
    }
}
