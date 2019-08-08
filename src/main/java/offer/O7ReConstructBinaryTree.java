package offer;

import bfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class O7ReConstructBinaryTree {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;

        int indexIn = indexForInOrders.get(pre[preL]);
        int lenofLeftTree = indexIn - inL;
        TreeNode root = new TreeNode(pre[preL]);

        root.left = reConstructBinaryTree(pre, preL + 1, preL + lenofLeftTree, inL);
        root.right = reConstructBinaryTree(pre, preL + lenofLeftTree + 1, preR, indexIn + 1);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        O7ReConstructBinaryTree solution = new O7ReConstructBinaryTree();
        TreeNode root = solution.reConstructBinaryTree(pre, in);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
