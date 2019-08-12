package offer;

// 233. Number of Digit One
//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//Example:
//
//Input: 13
//Output: 6
//Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
public class O43NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {13};
        int expected = 6;
    }
}
