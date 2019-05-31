package test;

import bfs.TreeNode;
// LC 	298	 Binary Tree Longest Consecutive Sequence
// 递归调用，记录父节点的值
// 特殊之处在于根节点，假设一个虚拟的父节点， 其值为根节点减一，
// 递归调用预期值是根节点的值
public class BinaryTreeLongestConsecutiveSequence {
    static class Result {
        public int res = 0;
    }

    int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        Result res = new Result();

        // call utility method with current length 0
        longestConsecutiveUtil(root, 0, root.val, res);

        return res.res;
    }

    private void longestConsecutiveUtil(TreeNode root, int curlength,
                                        int expected, Result res) {
        if (root == null)
            return;

        // if root data has one more than its parent
        // then increase current length
        if (root.val == expected)
            curlength++;
        else
            curlength = 1;

        // update the maximum by current length
        res.res = Math.max(res.res, curlength);

        // recursively call left and right subtree with
        // expected value 1 more than root data
        longestConsecutiveUtil(root.left, curlength, root.val + 1, res);
        longestConsecutiveUtil(root.right, curlength, root.val + 1, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        BinaryTreeLongestConsecutiveSequence s = new BinaryTreeLongestConsecutiveSequence();
        int length = s.longestConsecutive(root);
        System.out.println(length);
    }
}