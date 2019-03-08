package dfs;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return res;

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            res.add(list);
        }
        return res;
    }

}
