package dfs;

/*
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
    public void flatten(TreeNode root) {
        TreeNode cur = root, pre = root;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    // instead of cut the temp link in Morris traversal, we link it to right subtree
                    TreeNode right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                    pre.right = right;
                    cur = right;
                }
            } else {
                cur = cur.right;
            }
        }
    }
}
