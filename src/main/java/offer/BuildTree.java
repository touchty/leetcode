package offer;

import tree.TreeNode;

import java.util.List;

public class BuildTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        while (index < in.length) {
            if (in[index] == pre[0])
                break;
            index++;
        }
        int[] preLeft = new int[index];
        int[] inLeft = new int[index];
        for (int i = 0; i < preLeft.length; i++) {
            preLeft[i] = pre[i + 1];
        }
        for (int i = 0; i < inLeft.length; i++) {
            inLeft[i] = in[i];
        }

        int[] preRight = new int[pre.length - index - 1];
        int[] inRight = new int[in.length - index - 1];
        for (int i = 0; i < preRight.length; i++) {
            preRight[i] = pre[i + index + 1];
        }
        for (int i = 0; i < inRight.length; i++) {
            inRight[i] = in[i + index + 1];
        }

        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] in = {2, 1, 3};
        TreeNode root = reConstructBinaryTree(pre, in);
        List<Integer> listPre = TreeNode.preorderTraversal(root);
        List<Integer> listIn = TreeNode.inorderTraversal_Recursive(root);
        System.out.println(listPre);
        System.out.println(listIn);
    }
}
