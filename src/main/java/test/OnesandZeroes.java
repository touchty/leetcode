package test;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// LC 474. Ones and Zeroes
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeros = new int[strs.length];

        int[] ones = new int[strs.length];

        for (int p = 0; p < strs.length; p++) {
            String str = strs[p];
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zeros[p]++;
                else
                    ones[p]++;
            }
        }

        // 0-1 knapsack
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < strs.length; k++) {
                    if (zeros[k] <= i && ones[k] <= j) {
                        dp[k + 1][i][j] = Math.max(dp[k][i][j], 1 + dp[k][i - zeros[k]][j - ones[k]]);
                    } else {
                        dp[k + 1][i][j] = dp[k][i][j];
                    }
                }
            }

        }
        return dp[strs.length][m][n];
    }
    // 130ms

    public int findMaxForm2D(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int ones = 0;
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    zeros++;
                else
                    ones++;
            }
            // 正确行解释：
            // memo[i][j] = the max number of strings that can be formed with i 0's and j 1's
            // from the first few strings up to the current string s
            // Catch: have to go from bottom right to top left
            // Why? If a cell in the memo is updated(because s is selected),
            // we should be adding 1 to memo[i][j] from the previous iteration (when we were not considering s)
            // If we go from top left to bottom right, we would be using results from this iteration => overcounting
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i - zeros][j - ones] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    // 9 ms

/*
    // 16 ms
    // 错了
    static class Solution {

        HashMap<Integer, int[]> map = new HashMap<>();
        int res = 0;

        public int findMaxForm(String[] strs, int m, int n) {
            // 对数组长度进行排序
            // 主要目的是这一行的判断：
            // if (arr[0] + arr[1] > m + n)
            //                    return count;
            // 可以使遍历提前退出
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int val = s1.length() - s2.length();
                    if (val == 0)
                        return s1.compareTo(s2);
                    return val;
                }
            });

            for (int i = 0; i < strs.length; ++i) {
                String curr = strs[i];
                map.put(i, new int[2]);
                for (char c : curr.toCharArray()) {
                    map.get(i)[c - 48]++;
                }
            }

            for (int i = 0; i < strs.length; i++) {
                res = Math.max(res, helper(i, m, n, strs.length));
            }
            return res;
        }

        private int helper(int idx, int m, int n, int arrSize) {
            int count = 0;
            for (int i = idx; i < arrSize; ++i) {
                int[] arr = map.get(i);
                if (arr[0] + arr[1] > m + n)
                    return count;
                if (m >= arr[0] && n >= arr[1]) {
                    m -= arr[0];
                    n -= arr[1];
                    count++;
                }
            }
            return count;
        }
    }*/

    public static void main(String[] args) {
        String[] Array = {"10", "0001", "111001", "1", "0"};
        String[] ArrayExt = {"01", "0011", "0111", "01111", "1111111111", "11111111111111111111"};
        int m_ext = 3;
        int n_ext = 1000;
        int m = 5, n = 3; // zeros, ones
        OnesandZeroes s = new OnesandZeroes();
        int maxComponents = s.findMaxForm(Array, m, n);
        int maxComponents2D = s.findMaxForm2D(Array, m, n);
        System.out.println(maxComponents);
        Assert.assertEquals(maxComponents2D, maxComponents);

        /*Solution solution = new OnesandZeroes.Solution();
        int maxSubStr = solution.findMaxForm(ArrayExt, m_ext, n_ext);
        System.out.println(maxSubStr);*/

        int maxComponentsExt = s.findMaxForm(ArrayExt, m_ext, n_ext);
        System.out.println(maxComponentsExt);

    }
}
