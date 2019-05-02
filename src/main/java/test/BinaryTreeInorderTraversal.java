package test;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    // recursive
    List<Integer> list = new ArrayList<Integer>();

    public void inorderTraversalRecursive(TreeNode root) {
        if (root == null) return;
        inorderTraversalRecursive(root.left);
        list.add(root.val);
        inorderTraversalRecursive(root.right);
    }
}
