package tree;

public class KthNode {
    int k;

    TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k == 0)
            return null;
        this.k = k;
        return kthNodeHelper(root);
    }

    TreeNode kthNodeHelper(TreeNode root) {
        TreeNode target = null;
        if (root.left != null) {
            target = kthNodeHelper(root.left);
        }

        if (target == null) {
            if (k == 1)
                target = root;
            k--;
        }
        if (target == null && root.right != null) {
            target = kthNodeHelper(root.right);
        }
        return target;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int k = 4;
        KthNode s = new KthNode();
        TreeNode kthNode = s.kthNode(root, k);
        System.out.println(kthNode.val);
    }
}
