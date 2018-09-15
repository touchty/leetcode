package bst;

import java.util.*;

public class BinaryTreeInorderTraversal {

    // based on stack
    public List<Integer> inorderTraversal_Satck(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while (!s.empty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    //based on recursion
    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    // Binary Tree Inorder Traversal
    // Morris中序遍历，时间复杂度O(n)，空间复杂度O(1)

    public List inorderTraversal_Morris(TreeNode root) {
        ArrayList result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
                prev = cur;
                cur = cur.right;
            } else {
                /* 查找前驱 */
                TreeNode node = cur.left;
                while (node.right != null && node.right != cur)
                    node = node.right;

                if (node.right == null) { /* 还没线索化，则建立线索 */
                    node.right = cur;
                    /* prev = cur; 不能有这句，cur还没有被访问 */
                    cur = cur.left;
                } else {    /* 已经线索化，则访问节点，并删除线索  */
                    result.add(cur.val);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

}
