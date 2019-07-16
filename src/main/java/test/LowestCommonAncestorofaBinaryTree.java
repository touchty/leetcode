package test;

import bfs.TreeNode;

import java.util.*;

//236. Lowest Common Ancestor of a Binary Tree
// 最低公共祖先
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q)
            return root;

        TreeNode findL = lowestCommonAncestor(root.left, p, q);
        TreeNode findR = lowestCommonAncestor(root.right, p, q);

        if (findL != null && findR != null)
            return root;

        return findL == null ? findR : findL;

    }

    // 利用上一步结论
    // 每次找到两个节点的公共祖先
    // 删除这两个公共祖先
    // 添加公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return null;
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes)
            set.add(node);
        while (set.size() >= 2) {
            TreeNode p = set.iterator().next();
            set.remove(p);
            TreeNode q = set.iterator().next();
            set.remove(q);

            if (root == p || root == q) {
                set.add(root);
                continue;
            }

            TreeNode findL = lowestCommonAncestor(root.left, p, q);
            TreeNode findR = lowestCommonAncestor(root.right, p, q);

            if (findL != null && findR != null) {
                set.add(root);
                continue;
            }

            TreeNode commonOfPQ = (findL == null ? findR : findL);
            set.add(commonOfPQ);
        }
        if (set.size() == 1)
            return set.iterator().next();
        else
            return null;
    }


    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[6];
        for (int i = 1; i <= 6; i++) {
            nodes[i - 1] = new TreeNode(i);
        }
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].right = nodes[5];
        LowestCommonAncestorofaBinaryTree solution = new LowestCommonAncestorofaBinaryTree();
        TreeNode common46 = solution.lowestCommonAncestor(nodes[0], nodes[3], nodes[5]);
        TreeNode common45 = solution.lowestCommonAncestor(nodes[0], nodes[3], nodes[4]);
        System.out.println(common46.val);
        System.out.println(common45.val);
        TreeNode[] nodesTarget = {nodes[1], nodes[3], nodes[4], nodes[5]};
        TreeNode common245 = solution.lowestCommonAncestor(nodes[0], nodesTarget);
        System.out.println(common245.val);
    }
}
