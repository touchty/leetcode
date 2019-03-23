package stack;

import bfs.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        preHelper(root, pre);
        return pre;
    }

    public void preHelper(TreeNode root, List<Integer> pre) {
        if (root == null) return;
        pre.add(root.val);
        preHelper(root.left, pre);
        preHelper(root.right, pre);
    }

    public List<Integer> preorderIt(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        Deque<TreeNode> tovisit = new LinkedList<>();
        tovisit.push(root);
        while (!tovisit.isEmpty()) {
            TreeNode visiting = tovisit.pop();
            pre.add(visiting.val);
            if (visiting.right != null) tovisit.push(visiting.right);
            if (visiting.left != null) tovisit.push(visiting.left);
        }
        return pre;
    }
}
