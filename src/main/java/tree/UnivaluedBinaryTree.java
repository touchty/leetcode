package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 965. Univalued Binary Tree
 * Easy
 *
 * 60
 *
 * 15
 *
 * Favorite
 *
 * Share
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 */
public class UnivaluedBinaryTree {
    // DFS
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        if (root.left != null) {
            if (root.left.val != root.val)
                return false;
        }
        if (root.right != null) {
            if (root.right.val != root.val)
                return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    // BFS
    public boolean isUnivalTreeOpt(TreeNode root) {
        if (root == null)
            return true;
        int pVal = root.val;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val != pVal) {
                return false;
            }
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return true;
    }

}
