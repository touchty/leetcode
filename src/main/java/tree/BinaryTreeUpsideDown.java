package tree;

/**
 * Description
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given a binary tree {1,2,3,4,5}
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * return the root of the binary tree {4,5,2,#,#,3,1}.
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode res = upsideDownBinaryTree(l);
        l.right = root;
        l.left = r;
        root.left = null;
        root.right = null;
        return res;
    }

    public TreeNode upsideDownBinaryTreeIter(TreeNode root) {
        TreeNode cur = root, pre = null, next = null, tmp = null;
        while (cur != null) {
            next = cur.left;
            cur.left = tmp; // temp : right sibling
            tmp = cur.right; // store the right sibling
            cur.right = pre; // pre : parent node
            pre = cur; // keep forward
            cur = next; // keep forward
        }
        return pre;
    }
}
