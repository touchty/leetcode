package sort;

/*
769. Max Chunks To Make Sorted
Medium

415

73

Favorite

Share
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int min = 0;
        int max = arr[0];
        int partitions = 0;
        int left = 0;
        int right = 0;
        // sliding window
        while (right < arr.length) {
            max = Math.max(max, arr[right]);
            min = Math.min(min, arr[right]);
            if (max == right && min == left) {
                partitions++;
                left = right+1;
                // update the max and min of the next window
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            }
            right++;
        }
        return partitions;
    }

    public static void main(String[] args) {
        //int[] arr = {1,0,2,3,4};
        int[] arr = {4,3,2,1,0};
        MaxChunksToMakeSorted solution = new MaxChunksToMakeSorted();
        int res = solution.maxChunksToSorted(arr);
        System.out.println(res);
    }
}
