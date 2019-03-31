package algorithms;

import java.util.*;

//Permutations
public class Permutations {
    // no duplicate
    public List<List<Integer>> permutei(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtracki(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracki(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtracki(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // with duplicates
    public List<List<Integer>> permuteUniqueii(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackii(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrackii(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrackii(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
