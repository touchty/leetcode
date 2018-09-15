package linkedList;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        for (ListNode a = headA; a != null; a = a.next) {
            lenA++;
        }
        for (ListNode b = headB; b != null; b = b.next) {
            lenB++;
        }

        if (lenA == lenB) {
            while (headA != null) {

                if (headA == headB)
                    return headA;
                headA = headA.next;
                headB = headB.next;
            }
        } else if (lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
            while (headA != null) {

                if (headA == headB)
                    return headA;
                headA = headA.next;
                headB = headB.next;
            }
        } else {
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
            while (headA != null) {
                if (headA == headB)
                    return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }
        return headA;
    }
}
