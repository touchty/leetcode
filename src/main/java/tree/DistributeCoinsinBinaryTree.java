package tree;

import org.junit.Assert;

/*
979. Distribute Coins in Binary Tree
Medium

351

8

Favorite

Share
Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

There are N nodes and N coins.
Example 1:
Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 */
public class DistributeCoinsinBinaryTree {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    // take coins from parent. positive means give coins to parent,
    // and negative means take coins from parent.
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right); // steps to move coins from or to left and right sub tree
        return root.val + left + right - 1;  // every node have one coin at last.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        DistributeCoinsinBinaryTree solution = new DistributeCoinsinBinaryTree();
        int steps = solution.distributeCoins(root);
        Assert.assertEquals(2, steps);
    }
}
