package linkedList;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode L = null;
        ListNode R = null;
        ListNode node;
        int count = 1;
        for (node = head;node != null;node = node.next) {
            if (count == m)
                L = node;
            else if (count == n + 1)
            {
                R = node.next;
                break;
            }
            count++;
        }

        // reverse from m to n
        ListNode pivot = new ListNode(0);
        ListNode tempHead = pivot;
        ListNode remainingHead = L.next;
        for (int i = 0; i <= (n - m); i++) {
            ListNode pivotNext = pivot.next;
            ListNode remainingHeadNext = remainingHead.next;
            pivot.next = remainingHead;
            remainingHead.next = pivotNext;
            remainingHead = remainingHeadNext;
        }
        pivot = tempHead.next; // head of the reversed sub list

        L.next = pivot;
        while(pivot != null && pivot.next != null)
            pivot = pivot.next;

        pivot.next = R;
        head = temp.next;
        return head;
    }

    public ListNode reverseBetweenOpt(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummy;
        for(int i=1; i<m; i++){
            prev.next = curr;
            curr = curr.next;
            prev = prev.next;
        }

        //cool now reverse from m to n
        ListNode start = curr;
        ListNode rev = null;
        for(int i=m; i<=n; i++){
            ListNode next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }

        prev.next = rev;
        start.next = curr;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head= new ListNode(-1);
        ListNode realHead = head;
        for (int i : nums) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = node;
        }
        head = realHead.next;
        head = reverseBetween(head, 2,4);
        System.out.println(head.val);
    }
}
