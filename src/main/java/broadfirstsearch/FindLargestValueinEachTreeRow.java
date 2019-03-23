package broadfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        // size of the queue
        int size = 0;

        queue.add(root);
        size = queue.size();
        while (size > 0) {

            //  tempt max_val in the same row
            int max_val = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                root = queue.poll();
                max_val = Math.max(max_val, root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            res.add(max_val);
            size = queue.size();
        }
        List<Integer> max_val_in_rows = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            max_val_in_rows.add(res.get(res.size() - 1 - i));
        }
        return res;
    }

    public int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) resArray[i] = res.get(i);
        return resArray;
    }
}
