package dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        // inorder 中序遍历 左右相对关系
        // postorder 后序遍历
        // preorder 前序遍历
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            order.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode curr = new TreeNode(postorder[i]);
            if (order.get(curr.val) > order.get(stack.peek().val)) {
                stack.peek().right = curr;
            } else {
                TreeNode parent = stack.pop();
                while (!stack.isEmpty() && (order.get(curr.val) < order.get(stack.peek().val))) {
                    parent = stack.pop();
                }
                parent.left = curr;
            }
            stack.push(curr);
        }

        return root;
    }


    // DFS
    public TreeNode buildTreeDFS(int[] inorder, int[] postorder) {
        return dfs(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }

    private TreeNode dfs(int posStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (posStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posStart]);
        int inIndex = 0;

        // Get the position to seperate the array into left part and right part
        for (; inIndex <= inEnd; inIndex++) {
            if (inorder[inIndex] == root.val) {
                break;
            }
        }

        // inEnd - inIndex +　1 -------> number of right part
        // posStart + inIndex - inEnd - 1 ---------> root pos for left part

        root.left = dfs(posStart + inIndex - inEnd - 1, inStart, inIndex - 1, postorder, inorder);
        root.right = dfs(posStart - 1, inIndex + 1, inEnd, postorder, inorder);
        return root;
    }

}
