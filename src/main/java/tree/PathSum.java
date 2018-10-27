package tree;

import org.junit.Assert;
import sun.reflect.generics.tree.Tree;

public class PathSum {

    // wrong answer
    /*
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0) // cannot determine whether it's leaf node!
            return true;
        else if (root == null)
            return false;
        else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
    */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
