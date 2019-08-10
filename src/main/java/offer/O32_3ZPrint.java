package offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class O32_3ZPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean reversed = false; // 翻转
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
            if (reversed)
                Collections.reverse(list);
            lists.add(list);
        }
        return lists;
    }
}
