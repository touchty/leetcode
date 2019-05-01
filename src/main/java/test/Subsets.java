package test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, res, new ArrayList<>());
        return res;
    }

    void subset(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        if (start > nums.length)
            return;
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subset(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets solution = new Subsets();
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println(res.size());
        System.out.println(res);
    }
}
