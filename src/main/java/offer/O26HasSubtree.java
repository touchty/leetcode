package offer;

import tree.TreeNode;

public class O26HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return isSubTreeWithRoot(root1, root2) || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    boolean isSubTreeWithRoot(TreeNode root, TreeNode node) {
        if (node == null)
            return true;
        if (root == null)
            return false;

        boolean sameRoot = (root.val == node.val);
        if (sameRoot == false)
            return false;
        return sameRoot && isSubTreeWithRoot(root.left, node.left)
                && isSubTreeWithRoot(root.right, node.right);
    }
}
