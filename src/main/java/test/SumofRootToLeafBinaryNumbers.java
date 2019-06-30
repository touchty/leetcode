package test;

import bfs.TreeNode;

import java.util.*;

// LC 1022. Sum of Root To Leaf Binary Numbers
// 从根节点到叶子节点组成的二进制数字的和
public class SumofRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        int[] res = {0};
        dfs(root, new ArrayList<Integer>(), res);
        return res[0];
    }

    // 需要额外的空间
    void dfs(TreeNode root, List<Integer> list, int[] res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res[0] += root.val;
            int c = 2;
            for (int i = list.size() - 1; i >= 0; i--) {
                res[0] += list.get(i) * c;
                c *= 2;
            }
            return;
        }
        list.add(root.val);
        dfs(root.left, list, res);
        dfs(root.right, list, res);
        list.remove(list.size() - 1);
    }

    // 更高效
    public int dfsOpt(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return root.left == root.right ? val : dfsOpt(root.left, val) + dfsOpt(root.right, val);
    }

}
