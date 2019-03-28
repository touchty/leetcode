package tree;

/*
938. Range Sum of BST
Medium

226

24

Favorite

Share
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
 */
public class RangeSumofBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[1];
        dfs(root, sum, L, R);
        return sum[0];
    }

    void dfs(TreeNode root, int[] sum, int L, int R) {
        if (root == null) return;
        if (root.val <= R && root.val >= L)
            sum[0] += root.val;
        dfs(root.left, sum, L, R);
        dfs(root.right, sum, L, R);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        RangeSumofBST solution = new RangeSumofBST();
        int rangeSum = solution.rangeSumBST(root, 7, 15);
        System.out.println(rangeSum);
    }
}
