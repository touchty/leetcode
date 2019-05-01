package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 含有重复元素
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort for duplicate
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, 0, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void subset(int[] nums, int start, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (start > nums.length)
            return;
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length && !used[i]; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            subset(nums, i + 1, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
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
