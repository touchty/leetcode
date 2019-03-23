package tree;

/*
671. Second Minimum Node In a Binary Tree
Easy

343

497

Favorite

Share
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */

//dfs
public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        int[] twoMins = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        dfs(root, twoMins);
        if (twoMins[0] == twoMins[1] || twoMins[0] == Integer.MAX_VALUE || twoMins[1] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return twoMins[1];
        }
    }

    void dfs(TreeNode root, int[] twoMins) {
        if (root == null)
            return;
        if (root.val < twoMins[0]) {
            twoMins[1] = twoMins[0];
            twoMins[0] = root.val;
        } else if (root.val > twoMins[0] && root.val < twoMins[1])
            twoMins[1] = root.val;

        dfs(root.left, twoMins);
        dfs(root.right, twoMins);
    }
}
