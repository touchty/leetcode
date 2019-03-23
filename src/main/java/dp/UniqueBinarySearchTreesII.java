package dp;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class UniqueBinarySearchTreesII {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        /*
         * result[i] stores the result until length i.
         * For the result for length i+1, select the
         * root node j from 0 to i, combine the result
         * from left side and right side. Note for
         * the right side we have to clone the nodes
         * as the value will be offsetted by j.
         *
         * */
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {  //val <= j
                    for (TreeNode nodeR : result[len - j - 1]) {  //val <= len - j -1
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    public static List<TreeNode> generateTreesRewrite(int n) {
        List<TreeNode>[] result = new List[n + 1];

        result[0] = new ArrayList<TreeNode>();
        if (n == 0)
            return result[0];

        result[0].add(null);

        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j])
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
