package test;

import bfs.TreeNode;

// 判断平衡二叉树
public class BalancedBinaryTree {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    int depth(TreeNode root) {
        if (!isBalanced) return -1; // 提前退出

        if (root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false; // 在计算深度的时候判断是否平衡
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
