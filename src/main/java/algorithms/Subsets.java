package algorithms;

import java.util.*;
//  Subsets
public class Subsets {
    // no duplicate element in nums
    public List<List<Integer>> subsetsi(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracki(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtracki(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtracki(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    // with duplicates
    public List<List<Integer>> subsetsWithDupii(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackii(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrackii(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrackii(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
