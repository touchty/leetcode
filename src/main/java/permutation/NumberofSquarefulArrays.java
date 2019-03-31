package permutation;

import java.util.*;

/*
996. Number of Squareful Arrays
Hard

97

9

Favorite

Share
Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a
 perfect square.

Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is
some index i such that A1[i] != A2[i].

Example 1:
Input: [1,17,8]
Output: 2
Explanation:
[1,8,17] and [17,8,1] are the valid permutations.

Example 2:
Input: [2,2,2]
Output: 1
 */
public class NumberofSquarefulArrays {
    public int numSquarefulPerms(int[] A) {
        List<List<Integer>> lists = permuteUnique(A);
        return lists.size();
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                // check Squareful adjacent element
                if (tempList.size() >= 1) {
                    int sum = tempList.get(tempList.size() - 1) + nums[i];
                    int x = (int) Math.sqrt(sum);
                    if (Math.pow(x, 2) == sum) {
                        used[i] = true;

                        tempList.add(nums[i]);
                        backtrack(list, tempList, nums, used);
                        used[i] = false;
                        tempList.remove(tempList.size() - 1);
                    }
                } else {
                    used[i] = true;

                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] A = {6, 7, 8};
        NumberofSquarefulArrays solution = new NumberofSquarefulArrays();
        int count = solution.numSquarefulPerms(A);
        System.out.println(count);
    }
}
