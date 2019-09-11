package offer;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class O54KthNode {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k)
            ret = root;
        inOrder(root.right, k);
    }

    public TreeNode KthNodeIter(TreeNode pRoot, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || pRoot != null) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.poll();
            k--;
            if (k == 0)
                return pRoot;
            pRoot = pRoot.right;
        }
        return null;
    }
}
