package linkedList;

import bfs.TreeNode;

/*
114. Flatten Binary Tree to Linked List
Medium

1375

173

Favorite

Share
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBinaryTreetoLinkedList {
    private TreeNode next = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = next;
        root.left = null;
        next = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        FlattenBinaryTreetoLinkedList s = new FlattenBinaryTreetoLinkedList();
        s.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
