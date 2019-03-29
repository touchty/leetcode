package tree;

/**
 * 654. Maximum Binary Tree
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode constructMaximumBinaryTreeOpt(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode helper(int[] nums, int l, int r) {
        if (l > r || l < 0 || r < 0 || l >= nums.length || r >= nums.length)
            return null;

        int max_idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }

        TreeNode node = new TreeNode(nums[max_idx]);
        node.left = helper(nums, l, max_idx - 1);
        node.right = helper(nums, max_idx + 1, r);
        return node;
    }

    TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int maxIdx = left;
        int i = maxIdx + 1;
        int max = nums[maxIdx];
        while (i <= right) {
            if (nums[i] > max) {
                max = nums[i]; // update max element
                maxIdx = i; // update max index
            }
            i++;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = build(nums, left, maxIdx - 1);
        root.right = build(nums, maxIdx + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode root = maximumBinaryTree.constructMaximumBinaryTreeOpt(nums);
        System.out.println(root.val);
    }
}
