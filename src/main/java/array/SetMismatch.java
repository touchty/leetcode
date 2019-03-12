package array;

/*
645. Set Mismatch
Easy

382

212

Favorite

Share
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // the index we should to put abs(nums[i])
            int index = Math.abs(nums[i]) - 1;
            // if that position is already taken, i.e. negative
            // then it is duplicate
            if (nums[index] < 0) {
                res[0] = index + 1; // duplicate
            } else {
                // put it by marking negative
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            // index i is not put, then i + 1 missing
            // nums[i] > 0 means that index i is not accessed. index i is missing
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new SetMismatch().findErrorNums(new int[]{1, 2, 2, 3, 5});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
