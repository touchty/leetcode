package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 含有重复元素
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, LinkedList<Integer> tempList, int[] nums, int start) {
        list.add(new LinkedList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII solution = new SubsetsII();
        List<List<Integer>> res = solution.subsetsWithDup(nums);
        System.out.println(res.size());
        System.out.println(res);
    }
}
