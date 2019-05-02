package linkedList;

public class LinkedListHelper {
    public static ListNode create(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int LEN = nums.length;
        ListNode[] nodes = new ListNode[LEN];
        for (int i = 0; i < LEN; i++) {
            nodes[i] = new ListNode(nums[i]);
        }
        for (int i = 0; i < LEN - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        return nodes[0];
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.printf(head.val + "-> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode root = create(nums);
        System.out.println(root.val);
    }
}
