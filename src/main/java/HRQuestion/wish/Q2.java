package HRQuestion.wish;


public class Q2 {
    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        TreeNode left;
        TreeNode right;
        TreeNode p;
        int val;
    }

    static TreeNode next(TreeNode curr) {
        if (curr == null)
            return null;
        // left -> curr -> right
        // right exists
        if (curr.right != null) {
            TreeNode right = curr.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            // right does not exists
            // find from its parents
            TreeNode parent = curr.p;
            while (parent != null) {
                if (parent.left == curr) {
                    return parent;
                }
                curr = parent;
                parent = parent.p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /*
          2
         / \
        1   3
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.p = root;
        root.right = new TreeNode(3);
        root.right.p = root;

        TreeNode target1 = root.left;
        TreeNode target2 = root;
        TreeNode target3 = root.right;

        TreeNode p1 = next(target1); // 2
        TreeNode p2 = next(target2); // 3
        TreeNode p3 = next(target3); // none

        System.out.println(p1.val);
        System.out.println(p2.val);
        System.out.println(p3 == null);
        //System.out.println(p3.val);
    }
}
