package offer;

import tree.TreeNode;

public class O36Convert {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        inOrder(root);
        while (pre.left != null) {
            pre = pre.left;
        }
        return pre;
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
}
