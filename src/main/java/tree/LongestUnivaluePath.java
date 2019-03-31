package tree;

/*
687. Longest Univalue Path
Easy

886

194

Favorite

Share
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        doCount(root);
        return result;
    }

    private int doCount(TreeNode node) {
        if(node == null)
            return 0;
        int left = doCount(node.left);
        int right = doCount(node.right);
        if(node.left == null || node.left.val != node.val){
            left = 0;
        }
        if(node.right == null || node.right.val != node.val) {
            right =0;
        }
        result = Math.max(result, left+right); // max path length from node to its left and right most sub node
        return Math.max(left, right) + 1; // uni path from node to its left most or right  most sub node
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right= new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        LongestUnivaluePath solution = new LongestUnivaluePath();
        int maxLen = solution.longestUnivaluePath(root);
        System.out.println(maxLen);
    }
}
