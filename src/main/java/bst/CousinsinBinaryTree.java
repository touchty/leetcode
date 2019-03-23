package bst;

import java.util.LinkedList;
import java.util.Queue;

/*
993. Cousins in Binary Tree
Easy

70

4

Favorite

Share
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
 */
public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0, xd = -2, yd = -1; // assign different dummy values to xd & yd, the depths of x & y.
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                if (n.val == x) {
                    xd = depth;
                } // found x node
                else if (n.val == y) {
                    yd = depth;
                } // found y node
                // if x and y share same parent.
                if (n.left != null && n.right != null && (n.left.val == x && n.right.val == y || n.left.val == y && n.right.val == x)) {
                    return false;
                }
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            ++depth; // increase BFS depth.
        }
        return xd == yd; // Are x & y in the same depth?
    }
}
