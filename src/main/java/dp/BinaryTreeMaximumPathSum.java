package dp;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting
 * node to any node in the tree along the parent-child connections. The path must
 * contain at least one node and does not need to go through the root.
 * path -- single path
 * sum = left_path + right_path + node.val
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20*
 *     /  \
 *    15*  7*
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return (maxPath);
    }

    int maxPathDown(TreeNode node){
        if (node == null) return 0;

        int leftMax = Math.max(0, maxPathDown(node.left));

        int rightMax = Math.max(0, maxPathDown(node.right));

        maxPath = Math.max(maxPath, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
}
