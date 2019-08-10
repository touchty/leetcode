package offer;

import tree.TreeNode;

// 题目描述
//操作给定的二叉树，将其变换为源二叉树的镜像。
//输入描述:
//二叉树的镜像定义：源二叉树
//    	    8
//    	   /  \
//    	  6   10
//    	 / \  / \
//    	5  7 9 11
//    	镜像二叉树
//    	    8
//    	   /  \
//    	  10   6
//    	 / \  / \
//    	11 9 7  5
// 将二叉树镜像化
public class O27Mirror {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        // swap root' two sub tree
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        // recursive call
        Mirror(root.left);
        Mirror(root.right);
    }
}
