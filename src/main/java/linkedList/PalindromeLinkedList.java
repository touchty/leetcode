package linkedList;

public class PalindromeLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) return null;

        ListNode forward = head.next;
        head.next = null;
        while (forward != null) {
            ListNode next = forward.next;
            forward.next = head;
            head = forward;
            forward = next;
        }
        return head;
    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        int len = 0;
        ListNode h= head;
        while (h != null){
            len++;
            h = h.next;
        }

        ListNode mid = findMidNode(head);
        ListNode r = mid.next;
        mid.next = null;
        ListNode l = reverseLinkedList(head);

        if (len % 2 != 0)
            l = l.next;

        return isEqual(l, r);
    }

    static boolean isEqual(ListNode l, ListNode r) {
        while (l != null && r != null){
             if (l.val != r.val)
                 break;
             l = l.next;
             r = r.next;
         }

         if (l == null && r == null) return true;
         else return false;
    }
    //Runtime: 2 ms

    public boolean isPalindromeOpt(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            ListNode nextTemp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nextTemp;
        }
        if (fast != null) // odd len
        {
            slow = slow.next;
        }
        while (slow != null && pre != null)
        {
            if (slow.val != pre.val)
            {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        /*ListNode midNode = PalindromeLinkedList.findMidNode(l1);
        System.out.println("mid node: " + midNode.val);
        ListNode head = l1;
        head = PalindromeLinkedList.reverseLinkedList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/

        System.out.println(PalindromeLinkedList.isPalindrome(l1));
    }
}
