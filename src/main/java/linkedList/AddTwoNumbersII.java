package linkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0; //
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            list.val = sum % 10; //mod
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10; //carrier
        }
        return list.val == 0 ? list.next : list;
    }

    public static ListNode
    addTwoNumbersOpt(ListNode s1, ListNode s2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        // stack the s1
        while (s1 != null) {
            stack1.push(s1.val);
            s1 = s1.next;
        }

        while (s2 != null) {
            stack2.push(s2.val);
            s2 = s2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty())
                sum += stack1.pop();
            if (!stack2.isEmpty())
                sum += stack2.pop();
            ListNode head = new ListNode(sum / 10); // carrier
            list.val = sum % 10;
            head.next = list;
            list = head;
            sum /= 10;
        }
        if (list.val == 0)
            list = list.next;
        return list;
    }

    public static void main(String[] args) {
        int[] s1 = {1,2,3};
        int[] s2 = {4,9,9};
        ListNode s1_list = LinkedListHelper.create(s1);
        ListNode s2_list = LinkedListHelper.create(s2);
        ListNode sum_list = addTwoNumbersOpt(s1_list, s2_list);
        while (sum_list != null) {
            System.out.printf("%d ", sum_list.val);
            sum_list = sum_list.next;
        }
    }
}
/*
Runtime: 35 ms, faster than 41.00% of Java online submissions for Add Two Numbers II.
 */
