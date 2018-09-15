package linkedList;

import java.util.Collections;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        int[] result = isCircular(head);

        if (result[0] == 0)
            return null;
        ListNode nodeFollowing = head;
        for (int i = 0; i < result[1]; i++){
            nodeFollowing = nodeFollowing.next;
        }

        while (nodeFollowing != null){
            if (nodeFollowing == head) return head;
            head = head.next;
            nodeFollowing = nodeFollowing.next;
        }
        return null;
    }

    int[] isCircular(ListNode head) {
        int isCircular = 0;
        int length = 1;

        // result[0] <- isCircular; result <- length
        int[] result = new int[2];

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode travelNode = slow;
                while(travelNode.next != slow){
                    length++;
                    travelNode = travelNode.next;
                }
                result[0] = 1;
                result[1] = length;
                return result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        //
        l1.next = l2;
        l2.next = l3; l3.next = l4; l4.next = l2;

        int[] result = linkedListCycleII.isCircular(l1);
        for (int i:
             result) {
            System.out.println(i);
        }

        ListNode startNode = linkedListCycleII.detectCycle(l1);
        System.out.println(startNode.val);
    }
}
