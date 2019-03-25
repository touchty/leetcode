package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
958. Check Completeness of a Binary Tree
Medium

144

5

Favorite

Share
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

    public static void main(String[] args) {
        int[] nodeVal = {1, 2, 3, 4, 5, 6};
        TreeNode root = new TreeNode(nodeVal[0]);
        root.left = new TreeNode(nodeVal[1]);
        root.right = null;

        CheckCompletenessofaBinaryTree solution = new CheckCompletenessofaBinaryTree();
        boolean isComplete = solution.isCompleteTree(root);
        System.out.println(isComplete);
    }
}
