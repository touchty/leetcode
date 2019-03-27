package tree;

import java.util.*;

/*
662. Maximum Width of Binary Tree
Medium

573

85

Favorite

Share
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
 */
public class MaximumWidthofBinaryTree {
    // 34 ms
    public int widthOfBinaryTree(TreeNode root) {
        // bfs, with null taken into account
        if (root == null) return 0;
        Deque<TreeNode> deQueue = new LinkedList<>();
        deQueue.offer(root);
        int maxWidth = 0;
        while (deQueue.size() > 0) {
            int size = deQueue.size();
            maxWidth = Math.max(maxWidth, size);
            while (size-- > 0) {
                TreeNode node = deQueue.poll();
                if (node != null) {
                    deQueue.offer(node.left);
                    deQueue.offer(node.right);
                } else {
                    deQueue.offer(null);
                    deQueue.offer(null);
                }
            }
            // remove leading null in left and right
            while (deQueue.size() > 0) {
                // leading null in left
                if (deQueue.peekFirst() == null) deQueue.removeFirst();
                else
                    break;
            }
            while (deQueue.size() > 0) {
                // leading null in left
                if (deQueue.peekLast() == null) deQueue.removeLast();
                else
                    break;
            }
        }
        return maxWidth;
    }

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> width = new LinkedList<>();
            queue.offer(root);
            width.offer(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int left = width.peek();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    int wid = width.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        width.offer(2 * wid - 1);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        width.offer(2 * wid);
                    }
                    if (i == size - 1) {
                        res = Math.max(res, wid - left + 1);
                    }
                }
            }
            return res;
        }
    }

    // dfs
    class SolutionOpt {
        public int widthOfBinaryTree(TreeNode root) {
            return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
        }

        public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
            if (root == null) return 0;
            if (start.size() == level) { // first reach a new level
                start.add(order);
                end.add(order);
            } else end.set(level, order); // expend to right
            int cur = end.get(level) - start.get(level) + 1;
            int left = dfs(root.left, level + 1, 2 * order, start, end); // ending in left part
            int right = dfs(root.right, level + 1, 2 * order + 1, start, end); // ending in right part
            return Math.max(cur, Math.max(left, right));
        }
    }

    public static void main(String[] args) {
        /*
           1
         /   \
        3     2
       / \     \
      5   3     9
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        TreeNode left = root.left;
        left.left = new TreeNode(5);
        left.right = new TreeNode(3);
        TreeNode right = root.right;
        right.right = new TreeNode(9);

        MaximumWidthofBinaryTree solution = new MaximumWidthofBinaryTree();
        int maxWidth = solution.widthOfBinaryTree(root);
        System.out.println(maxWidth);
    }
}
