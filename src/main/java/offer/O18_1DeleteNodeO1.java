package offer;

import array.ListNode;

public class O18_1DeleteNodeO1 {
    public static ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return head;

        if (head == tobeDelete) {
            head = head.next;
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur == tobeDelete) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        root = O18_1DeleteNodeO1.deleteNode(root, root.next.next);
        System.out.println(root.val);
    }
}
