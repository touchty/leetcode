package test;

import tree.TreeNode;

// LC 979. Distribute Coins in Binary Tree
// 分配硬币
public class DistributeCoinsinBinaryTree {
    int total = 0;
    public int distributeCoinsHelper(TreeNode root) {
        if (root == null)
            return 0;
        int left = distributeCoinsHelper(root.left);
        int right = distributeCoinsHelper(root.right);
        int res = (-1 + root.val + left + right);
        total += Math.abs(res);

        return res;
    }

    public int distributeCoins(TreeNode root) {
        distributeCoinsHelper(root);
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        DistributeCoinsinBinaryTree solution = new DistributeCoinsinBinaryTree();
        System.out.println(solution.distributeCoins(root));
    }
}
