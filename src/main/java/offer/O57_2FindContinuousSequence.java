package offer;

import java.util.ArrayList;

// 57.2 和为 S 的连续正数序列
//NowCoder
//
//题目描述
//输出所有和为 S 的连续正数序列。
//
//例如和为 100 的连续序列有：
//
//[9, 10, 11, 12, 13, 14, 15, 16]
//[18, 19, 20, 21, 22]。
//解题思路
// 滑动窗口
public class O57_2FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int sum = 100;
        O57_2FindContinuousSequence solution = new O57_2FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = solution.FindContinuousSequence(sum);
        System.out.println(lists);
    }
}
