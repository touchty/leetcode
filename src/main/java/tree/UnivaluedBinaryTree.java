package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 965. Univalued Binary Tree
 * Easy
 * <p>
 * 60
 * <p>
 * 15
 * <p>
 * Favorite
 * <p>
 * Share
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * <p>
 * <p>
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
