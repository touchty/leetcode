package tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        TreeNode rightInv = invertTree(root.right);
        TreeNode leftInv = invertTree(root.left);

        root.left = rightInv;
        root.right = leftInv;

        return root;
    }
}
