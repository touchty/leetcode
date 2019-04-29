package dfs;

/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * */
public class ConvertSortedListtoBinarySearchTree {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while (runner != null) {
            runner = runner.next;
            size++;
        }

        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);
        // mid is "removed" since we have created a new tree node
        // from the list. Consequently, the number of nodes in list is decreased by one.

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        TreeNode right = inorderHelper(mid + 1, end);
        treenode.right = right;

        return treenode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        ConvertSortedListtoBinarySearchTree s = new ConvertSortedListtoBinarySearchTree();
        TreeNode root = s.sortedListToBST(head);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
