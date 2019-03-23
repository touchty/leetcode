package tree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSubtreeOpt(TreeNode s, TreeNode t) {
        return isSubtreeHelper(s, t, 0);
    }

    public boolean isSubtreeHelper(TreeNode s, TreeNode t, int depth) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val == t.val) {
            if (isSubtreeHelper(s.left, t.left, depth + 1) && isSubtreeHelper(s.right, t.right, depth + 1)) {
                return true;
            }
        } else {
            if (depth > 0)
                return false;
        }

        return isSubtreeHelper(s.left, t, depth) || isSubtreeHelper(s.right, t, depth);
    }
}
