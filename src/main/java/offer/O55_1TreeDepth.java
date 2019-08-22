package offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class O55_1TreeDepth {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    // 662. Maximum Width of Binary Tree
    // 二叉树的最大宽度
    // 二叉树可以用数组来存储，n的左右节点的位置是 2*n, 2*n + 1
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) { // first reach a new level
            start.add(order);
            end.add(order);
        } else end.set(level, order); // expend to right
        int cur = end.get(level) - start.get(level) + 1; // 当前level的宽度

        // dfs(root.left)先调用，可能会更新下一层的start和end数组
        int left = dfs(root.left, level + 1, 2 * order, start, end); // ending in left part
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end); // ending in right part
        return Math.max(cur, Math.max(left, right));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        O55_1TreeDepth solution = new O55_1TreeDepth();
        int depth = solution.TreeDepth(root);
        int width = solution.widthOfBinaryTree(root);
        System.out.println(depth);
        System.out.println(width);
    }
}
