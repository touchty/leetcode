package tree;

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    /**
     * For every node, length of longest path which pass
     * it = MaxDepth of its left subtree + MaxDepth of its right subtree.
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;  // one path, no fork
    }

    public int diameterOfBinaryTreeOpt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        helper (root, max);
        return max[0];

    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (left + right  > max[0]) {
            max[0] = left + right ;
        }
        return Math.max(left, right) + 1;
    }
}
