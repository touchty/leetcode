package offer;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class O55_1TreeDepth {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    private int width = 0;

    public int treeWidth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            this.width = Math.max(this.width, size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return this.width;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        O55_1TreeDepth solution = new O55_1TreeDepth();
        int depth = solution.TreeDepth(root);
        int width = solution.treeWidth(root);
        System.out.println(depth);
        System.out.println(width);
    }
}
