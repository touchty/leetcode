package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean toRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (toRight) {
                    list.addFirst(root.val);
                } else {
                    list.add(root.val);
                }
                if (root.right != null) queue.offer(root.right);
                if (root.left != null) queue.offer(root.left);
            }
            res.add(list);
            toRight = !toRight;
        }
        return res;
    }
}
