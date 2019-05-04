package test;

import bfs.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    // 左左==右右
    // 左右==右左
    boolean helper(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return left == null;

        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
