package test;

import bfs.TreeNode;

// 1123. Lowest Common Ancestor of Deepest Leaves
// 最深叶子节点的公共祖先
// 判断最深
public class LowestCommonAncestorofDeepestLeaves {
    // Node 以及到叶子节点的最大深度d
    class Pair {
        TreeNode node;
        int d;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    private Pair getLca(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);
        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);
        if (l.d == r.d) {
            return new Pair(root, l.d);
        } else {
            return l.d > r.d ? l : r;
        }
    }
}
