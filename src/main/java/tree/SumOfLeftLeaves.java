package tree;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null)
            return left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }
}
