package linkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode oddHead = odd;

        ListNode even = odd.next;
        ListNode evenHead =  even;

        while (odd != null && even != null){
            if (even.next == null) break;
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;

    }
}
