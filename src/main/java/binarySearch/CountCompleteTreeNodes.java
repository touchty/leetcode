package binarySearch;

public class CountCompleteTreeNodes {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int h = height(root);

        int count = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                count += 1 << h;  // left subtree
                root = root.right;
            } else {
                count += 1 << (h - 1); // right subtree
                root = root.left;
            }
            h--;
        }
        return count;

    }
}
