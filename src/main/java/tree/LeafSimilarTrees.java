package tree;

import java.util.Deque;
import java.util.LinkedList;

/*
872. Leaf-Similar Trees
Easy

336

19

Favorite

Share
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value
sequence.
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1 = new LinkedList<>(), s2 = new LinkedList<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty())
            if (dfs(s1) != dfs(s2)) return false;
        return s1.isEmpty() && s2.isEmpty();
    }

    public int dfs(Deque<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }

    public static void main(String[] args) {
        /*
           1
         /   \
        3     2
       / \     \
      5   3     9

    ########################
           1
         /   \
        3     2
       /     / \
      5     3   9
         */
        TreeNode rootL = new TreeNode(1);
        rootL.left = new TreeNode(3);
        rootL.right = new TreeNode(2);
        TreeNode left = rootL.left;
        left.left = new TreeNode(5);
        left.right = new TreeNode(3);
        TreeNode right = rootL.right;
        right.right = new TreeNode(9);

        TreeNode rootR = new TreeNode(1);
        rootR.left = new TreeNode(3);
        rootR.right = new TreeNode(2);
        TreeNode left1 = rootR.left;
        left1.left = new TreeNode(5);
        TreeNode right1 = rootR.right;
        right1.left = new TreeNode(3);
        right1.right = new TreeNode(9);

        LeafSimilarTrees solution = new LeafSimilarTrees();
        boolean result = solution.leafSimilar(rootL, rootR);
        System.out.println(result);
    }
}
