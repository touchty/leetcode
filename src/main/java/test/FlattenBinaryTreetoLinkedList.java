package test;

import tree.TreeNode;

import java.util.ArrayList;

/*
114. Flatten Binary Tree to Linked List
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
题目讲解：
  a
 / \
B   C
a ->flat(B)->flat(C)
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i + 1);
        }
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    /*

     */
    private TreeNode next = null;

    public void flattenOpt(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = this.next;
        root.left = null;
        this.next = root;
    }
}
