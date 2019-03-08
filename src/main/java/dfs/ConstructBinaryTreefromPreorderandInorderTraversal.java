package dfs;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public TreeNode buildTreeNoRecursion(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // preorder = [3,9,20,15,7]
        // inorder = [9,3,15,20,7]

        // preStart = preStart + 1, as new root
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // preStart = preeStart + inIndex - inStart + 1, as new root

        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
