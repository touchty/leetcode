package array;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * Example 1:
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */
public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        int[] left = new int[n], right = new int[n];
        Deque<int[]> s1 = new LinkedList<>(), s2 = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[] {A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[] {A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * left[i] * right[i]) % mod;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int res = sumSubarrayMins(nums);
        int expected = 17;
        Assert.assertEquals(expected, res);
    }

    class Solution {
        public int sumSubarrayMins(int[] A) {
            Deque<Integer> stackPrev = new LinkedList<>(); // idx
            Deque<Integer> stackNext = new LinkedList<>(); // idx
            int Len = A.length;
            int[] prev = new int[Len];
            int[] next = new int[Len];

            for (int i = 0; i < Len; i++) {
                prev[i] = i+1;
                next[i] = Len - i;
            }

            for (int i = 0; i < Len; i++) {
                while (!stackPrev.isEmpty() && A[i] < A[stackPrev.peek()])
                    stackPrev.pop();
                prev[i] = stackPrev.isEmpty() ? i + 1 : i - stackPrev.peek();
                stackPrev.push(i);

                while(!stackNext.isEmpty() && A[i] < A[stackNext.peek()]) {
                    int x = stackNext.pop();
                    next[x] = i - x;
                }
                stackNext.push(i);
            }

            int ans = 0, mod = (int)1e9 +7;
            for(int i = 0; i < Len; i++){
                ans = (ans + A[i]*prev[i]*next[i])%mod;
            }
            return ans;
        }
    }
}

/*
C++ version
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
      while(!in_stk_p.empty() && in_stk_p.top().first > A[i]) in_stk_p.pop();
      left[i] = in_stk_p.empty()? i + 1: i - in_stk_p.top().second;
      in_stk_p.push({A[i],i});

      // for next less
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