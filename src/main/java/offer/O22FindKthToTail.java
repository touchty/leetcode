package offer;

import linkedList.ListNode;

// 22. 链表中倒数第 K 个结点
// NowCoder
//
// 解题思路
// 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，可以知道当 P1
// 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
public class O22FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode P1 = head;
        while (P1 != null && k-- > 0)
            P1 = P1.next;
        if (k > 0)
            return null;
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        ListNode node1 = O22FindKthToTail.FindKthToTail(root, 1);
        System.out.println(node1.val);

        ListNode node2 = O22FindKthToTail.FindKthToTail(root, 2);
        System.out.println(node2.val);

        ListNode node3 = O22FindKthToTail.FindKthToTail(root, 3);
        System.out.println(node3.val);
    }
}
