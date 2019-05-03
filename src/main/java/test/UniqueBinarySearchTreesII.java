package test;

import bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 输出所有可能的查找二叉树

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i); // 必须新建
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        List<TreeNode> trees = solution.generateTrees(n);
        for (TreeNode root : trees){
            System.out.println(root.val);
        }
    }
}
