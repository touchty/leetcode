package tree;

/*
124. Binary Tree Maximum Path Product
 */
public class BinaryTreeMaximumPathProduct {
    int max = Integer.MIN_VALUE;

    public int maxPathProduct(TreeNode root) {
        dfs(root);
        return max;
    }

    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{1, 1};
        int[] res = new int[2];
        res[0] = root.val;
        res[1] = root.val;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        for (int i : left) {
            res[0] = Math.min(res[0], i * root.val);
            res[1] = Math.max(res[1], i * root.val);
        }
        for (int i : right) {
            res[0] = Math.min(res[0], i * root.val);
            res[1] = Math.max(res[1], i * root.val);
        }

        for (int i : left) {
            for (int j : right) {
                res[0] = Math.min(res[0], i * j * root.val);
                res[1] = Math.max(res[1], i * j * root.val);
            }
        }
        max = Math.max(max, res[1]);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-3);
        root.right = new TreeNode(-4);
        BinaryTreeMaximumPathProduct s = new BinaryTreeMaximumPathProduct();
        int max = s.maxPathProduct(root);
        System.out.println(max);
    }
}
