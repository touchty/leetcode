package dp;

/*
600. Non-negative Integers without Consecutive Ones
Hard

214

61

Favorite

Share
Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
Note: 1 <= n <= 109
 */
public class NonnegativeIntegerswithoutConsecutiveOnes {
    // Memory Limit Exceeded
    public int findIntegers(int num) {
        boolean[] dp = new boolean[num + 1];
        dp[0] = true;
        //
        for (int i = 1; i <= num; i++) {
            if ((i & 3) == 3) dp[i] = false;
            else {
                dp[i] = dp[i / 2];
            }
        }

        int res = 0;
        for (int i = 0; i <= num; i++) {
            res += dp[i] ? 1 : 0;
        }
        return res;
    }


    // Reference: http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
    public int findIntegersOpt(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 1000000000};
        int[] res = new int[nums.length];
        NonnegativeIntegerswithoutConsecutiveOnes s =
                new NonnegativeIntegerswithoutConsecutiveOnes();
        for (int i = 0; i < nums.length; i++) {
            res[i] = s.findIntegersOpt(nums[i]);
        }
        int[] expected = {1, 2, 3, 3, 4, 5, 5};
        //Assert.assertArrayEquals(expected, res);
    }
}
