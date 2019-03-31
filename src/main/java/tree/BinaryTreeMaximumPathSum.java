package tree;

/*
124. Binary Tree Maximum Path Sum
Hard

1378

101

Favorite

Share
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        left = Math.max(left, 0); // no left sub node
        right = Math.max(right, 0); // no right sub node
        maxSum = Math.max(maxSum, left + right  + node.val);
        return Math.max(left, right) + node.val; // max sum of one path from he current node to the left or to the right.
    }
}
