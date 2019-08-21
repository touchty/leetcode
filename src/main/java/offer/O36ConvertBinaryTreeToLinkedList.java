package offer;

import tree.TreeNode;

public class O36ConvertBinaryTreeToLinkedList {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        root.left = pre;
        if (pre != null)
            pre.right = root;
        pre = root;
        // left most node
        if (head == null)
            head = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        O36ConvertBinaryTreeToLinkedList solution =
                new O36ConvertBinaryTreeToLinkedList();
        TreeNode head = solution.Convert(root);
        System.out.println(head.val);
        System.out.println(head.right.val);
        System.out.println(head.right.right.val);
    }
}
