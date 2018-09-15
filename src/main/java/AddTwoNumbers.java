public class AddTwoNumbers {
	public static void main(String[] args) {
		// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		ListNode[] nodes1 = new ListNode[3];
		ListNode[] nodes2 = new ListNode[3];
		int[] vals1 = {2,4,3};
		int[] vals2 = {5,6,4};

		for (int i = 0; i < 3; ++i) {
			nodes1[i] = new ListNode(vals1[i]);
		}
		nodes1[0].next = nodes1[1];
		nodes1[1].next = nodes1[2];

		for (int i = 0; i < 3; ++i) {
			nodes2[i] = new ListNode(vals2[i]);
		}
		nodes2[0].next = nodes2[1];
		nodes2[1].next = nodes2[2];

		ListNode nodesResult = AddTwoNumbers.addTwoNumbers(nodes1[0], nodes2[0]);
		for (ListNode tmp = nodesResult;tmp != null ; tmp = tmp.next) {
			System.out.println("" + tmp.val + "->");
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
    	ListNode prev = new ListNode(0);
    	ListNode head = prev;
    	int carry = 0;
    	while (l1 != null || l2 != null || carry != 0){
    		ListNode cur = new ListNode(0);
    		int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
    		cur.val = sum % 10;
    		carry = sum / 10;
    		prev.next = cur;
    		prev = cur;

    		l1 = (l1 == null) ? null : l1.next;
    		l2 = (l2 == null) ? null : l2.next;
    	}
    	return head.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; 
	}
}