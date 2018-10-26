package stack;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];

        Arrays.fill(next, -1);
        // the elements in stack are element which has no greater next num.
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;

            if (i < n) stack.push(i);
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] res = nextGreaterElements(nums);
        int[] expected = new int[]{2, -1, 2};
        Assert.assertArrayEquals(expected, res);
    }
}
/*
C++ Version
class Solution {
public:
  int sumSubarrayMins(vector<int>& A) {
    stack<pair<int, int>> in_stk_p, in_stk_n;
    // left is for the distance to previous less element
    // right is for the distance to next less element
    vector<int> left(A.size()), right(A.size());

    //initialize
    for(int i = 0; i < A.size(); i++) left[i] =  i + 1;
    for(int i = 0; i < A.size(); i++) right[i] = A.size() - i;

    for(int i = 0; i < A.size(); i++){
      // for previous less
      // contains no dup
      while(!in_stk_p.empty() && in_stk_p.top().first > A[i]) in_stk_p.pop();
      left[i] = in_stk_p.empty()? i + 1: i - in_stk_p.top().second;
      in_stk_p.push({A[i],i});

      // for next less
      // contains dup in right part
      while(!in_stk_n.empty() && in_stk_n.top().first > A[i]){
        auto x = in_stk_n.top();in_stk_n.pop();
        right[x.second] = i - x.second;
      }
      in_stk_n.push({A[i], i});
    }

    int ans = 0, mod = 1e9 +7;
    for(int i = 0; i < A.size(); i++){
      ans = (ans + A[i]*left[i]*right[i])%mod;
    }
    return ans;
  }
};
 */
