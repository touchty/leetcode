package HRQuestion.xiaomi;

import tree.TreeNode;

// 	536	Construct Binary Tree from String
// 前序遍历重建二叉树

public class Q2 {
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;

        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);

        if (firstParen == -1) return cur;

        int start = firstParen, leftParenCount = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftParenCount++;
            else if (s.charAt(i) == ')') leftParenCount--;

            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (leftParenCount == 0) {
                cur.right = str2tree(s.substring(start + 1, i));
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String tree = "1(2(3)(4()(5)))(6(7)())";
        TreeNode root = str2tree(tree);
        System.out.println(TreeNode.inorderTraversal_Recursive(root));
    }
}
