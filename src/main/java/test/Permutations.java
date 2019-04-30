package test;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, 0, res);
        return res;
    }

    void backTracing(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backTracing(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
