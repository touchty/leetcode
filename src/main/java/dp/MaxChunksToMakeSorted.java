package dp;

/*
769. Max Chunks To Make Sorted
Medium

410

72

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
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        // lowestInRight[i] is minimum element in {arr[i], arr[i+1], ..., arr[arr.length -1]
        int[] lowestInRight = new int[arr.length];
        lowestInRight[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            lowestInRight[i] = Math.min(arr[i], lowestInRight[i + 1]);
        }

        // maximum element from a certain index to i
        int max = arr[0];
        int result = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
            if (max < lowestInRight[i + 1]) {
                // can be a chunk
                result++;
                max = arr[i + 1]; // new chunk
            }
        }
        return result;
    }
}
