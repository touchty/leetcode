package test;

import bfs.TreeNode;
// 1120. Maximum Average Subtree
public class MaximumAverageSubtree {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    private class ResultType {
        int sum;
        int size;
        TreeNode root;

        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    TreeNode maxtree = null;
    ResultType result = null;

    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxtree;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType subresult = new ResultType(left.sum + right.sum + root.val,
                left.size + right.size + 1);

        if (maxtree == null || subresult.sum * result.size > subresult.size * result.sum) {
            maxtree = root;
            result = subresult;
        }
        return subresult;
    }
}
