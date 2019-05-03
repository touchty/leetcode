package test;

import bfs.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// 查找二叉树的第K个元素
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return root.val;
    }
}
