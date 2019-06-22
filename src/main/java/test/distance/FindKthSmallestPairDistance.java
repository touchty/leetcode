package test.distance;

import java.util.Arrays;

// 719. Find K-th Smallest Pair Distance
/*
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:

Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.


Note:

2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.


这道题给了我们一个数组，让我们找第k小的数对儿距离，数对儿距离就是任意两个数字之间的绝对值差。那么我们先来考虑最暴力的解法，
是不是就是遍历任意两个数字，算出其绝对值差，然后将所有距离排序，取第k小的就行了。But，OJ摇着头说图样图森破。但是我们可以在纯暴力搜索的基础上
做些优化，从而让OJ说YES。那么下面这种利用了桶排序的解法就是一种很好的优化，题目中给了数字的大小范围，不会超过一百万，所以我们就建立一百万个桶，
然后还是遍历任意两个数字，将计算出的距离放到对应的桶中，这里桶不是存的具体距离，而是该距离出现的次数，桶本身的位置就是距离，所以我们才建立了一
百万个桶。然后我们就可以从0开始遍历到一百万了，这样保证了我们先处理小距离，如果某个距离的出现次数大于等于k了，那么我们返回这个距离，否则就用k减去这个距离的出现次数，参见代码如下：
 */
public class FindKthSmallestPairDistance {
    class Solution {
        // Returns index of first index of element which is greater than key
        private int upperBound(int[] a, int low, int high, int key) {
            if (a[high] <= key) return high + 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (key >= a[mid]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        // Returns number of pairs with absolute difference less than or equal to mid.
        private int countPairs(int[] a, int mid) {
            int n = a.length, res = 0;
            for (int i = 0; i < n; i++) {
                res += upperBound(a, i, n - 1, a[i] + mid) - i - 1;
            }
            return res;
        }

        public int smallestDistancePair(int a[], int k) {
            int n = a.length;
            Arrays.sort(a);

            // Minimum absolute difference
            int low = a[1] - a[0];
            for (int i = 1; i < n - 1; i++)
                low = Math.min(low, a[i + 1] - a[i]);

            // Maximum absolute difference
            int high = a[n - 1] - a[0];

            // Do binary search for k-th absolute difference
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (countPairs(a, mid) < k)
                    low = mid + 1;
                else
                    high = mid;
            }

            return low;
        }
    }

    class SolutionOpt {
        private int get(int[] nums, int value) {
            int i, j = 0, n = nums.length, ans = 0;
            for (i = 0; i < n; i++) {
                while (nums[i] - nums[j] > value) {
                    j++;
                }
                ans += (i - j); // i...j :(i, j), (i+1, j), ... (j-1, j) 总共(i-j)对
            }
            return ans;
        }

        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int low = 0, high = nums[n - 1] - nums[0];
            while (low < high) {
                int mid = (low + high) / 2;
                int index = get(nums, mid);
                if (index < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
