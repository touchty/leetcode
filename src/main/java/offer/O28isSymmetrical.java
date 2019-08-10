package offer;

import tree.TreeNode;

public class O28isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        return p.val == q.val && isSymmetrical(p.left, q.right)
                && isSymmetrical(p.right, q.left);
    }
}
