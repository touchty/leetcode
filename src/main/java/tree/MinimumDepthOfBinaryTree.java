package tree;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 * <p>
 * Attention : the end of the path should be a leaf node!
 * 3
 * /
 * 9
 * The answer should be 2, not 1.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null) // leaf node
            return 1;
        else if (root.left == null && root.right != null) // the path leads to the right subtree
            return 1 + minDepth(root.right);
        else if (root.left != null && root.right == null) // the path leads to the left subtree
            return 1 + minDepth(root.left);
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1; // the path is the shorter path of two paths
    }

    public int minDepthOpt(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }
}
