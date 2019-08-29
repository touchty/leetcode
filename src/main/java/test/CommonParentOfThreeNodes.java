package test;

import java.util.Arrays;

/**
 * 在一棵满二叉排序树深度为k，节点数为2^k-1;节点值为1至（2^k - 1）,给出k和任意三个节点的值，输出包含该三个节点的最小子树的根节点。
 * <p>
 * 样例输入：4 10 15 13
 * <p>
 * 样例输出：12
 * <p>
 * 首先，我们来理解一下满二叉排序树，如下就是一个4层的满二叉排序树：
 * <p>
 * *            8
 * *        /       \
 * *       4        12
 * *      / \      /   \
 * *     2   6   10   14
 * *    /\ /\   / \   /  \
 * *   1 3 5 7 9 11 13 15
 */
public class CommonParentOfThreeNodes {
    public static void main(String[] args) {
        int[] nums = {10, 15, 13};
        int k = 4;
        CommonParentOfThreeNodes parentOfThreeNodes = new CommonParentOfThreeNodes();

        int p = parentOfThreeNodes.root(nums, k);
        System.out.println(p);
    }

    int root(int[] nums, int k) {
        Arrays.sort(nums);

        int parent = rootOfThree(nums, 2 * k, k);
        return parent;
    }

    int rootOfThree(int[] nums, int k, int level) {
        if (level <= 0)
            return -1;
        // right
        if (nums[0] > k) {
            return rootOfThree(nums, k + level, level / 2);
        }
        // left
        else if (nums[2] < k) {
            return rootOfThree(nums, k - level, level / 2);
        } else {
            // find
            return k;
        }
    }
}