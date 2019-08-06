package test;

import java.util.Arrays;

/*
链接：https://www.nowcoder.com/questionTerminal/adc291e7e79f452c8b59243a5ce68d3a?toCommentId=765685
来源：牛客网

[编程题]有趣的排序
热度指数：6426时间限制：1秒空间限制：32768K
算法知识视频讲解
度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
任取数组中的一个数然后将它放置在数组的最后一个位置。
问最少操作多少次可以使得数组从小到大有序？

输入描述:
首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)


输出描述:
输出一个整数表示最少的操作次数。
示例1
输入
4
19 7 8 25
输出
2
 */
public class FunnySort {
    static int funnySort(int[] nums) {
        int count = 0;
        int[] origin = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            origin[i] = nums[i];
        }
        Arrays.sort(nums);
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (origin[i] == nums[j]) {
                count++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {19, 7, 8, 25};
        int res = FunnySort.funnySort(nums);
        System.out.println(res);

        int[] nums1 = {(2), (8), 16, 19, (10), 24, 23, 25};
        int res1 = FunnySort.funnySort(nums1);
        System.out.println(res1);
    }
}
