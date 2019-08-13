package offer;

import tree.TreeNode;

public class O55_2IsBalanced_Solution {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (!isBalanced)
            return -1;
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return Math.max(left, right) + 1;
    }
}
