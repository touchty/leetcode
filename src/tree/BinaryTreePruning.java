package tree;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null || dfsWeight(root) == 0)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    int dfsWeight(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + dfsWeight(node.left) + dfsWeight(node.right);
    }

    public TreeNode pruneTreeOpt(TreeNode root) {
        if (shouldPruneTree(root)) {
            return null;
        }
        return root;
    }

    // Return whether or not tree should be pruned.
    private boolean shouldPruneTree(TreeNode root) {
        if (root.left != null) {
            if (shouldPruneTree(root.left)) {
                root.left = null;
            }
        }

        if (root.right != null) {
            if (shouldPruneTree(root.right)) {
                root.right = null;
            }
        }

        if (root.left == null && root.right == null && root.val == 0) {
            return true;
        }
        return false;
    }
}
