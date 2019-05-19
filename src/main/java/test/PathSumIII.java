package test;

import bfs.TreeNode;
// 从一个节点向子节点，满足和为sum
// 注意该递归的不同之处，不仅调用自身还调用了另外的函数
// 不同之处注意
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int pathFrom(TreeNode start, int sum) {
        if (start == null) return 0;

        return (start.val == sum ? 1 : 0) +
                pathFrom(start.left, sum - start.val) + pathFrom(start.right, sum - start.val) ;
    }
}
