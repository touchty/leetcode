package dp;

import java.util.Arrays;

/*
730. Count Different Palindromic Subsequences
Hard

243

23

Favorite

Share
Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

Example 1:
Input:
S = 'bccb'
Output: 6
Explanation:
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
Example 2:
Input:
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation:
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 */
public class CountDifferentPalindromicSubsequences {
    int[][] meno, prev, next;
    byte[] A;
    int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String S) {
        int N = S.length();
        meno = new int[N][N];
        prev = new int[N][4];
        next = new int[N][4];
        byte[] A = new byte[N];
        for (int i = 0; i < S.length(); i++) {
            A[i] = (byte) (S.charAt(i) - 'a');
        }
        int[] Last = new int[4];
        Arrays.fill(Last, -1);
        for (int i = 0; i < N; i++) {
            Last[A[i]] = i;
            for (int j = 0; j < 4; j++) {
                prev[i][j] = Last[j];
            }
        }
        Arrays.fill(Last, -1);
        for (int i = N - 1; i >= 0; i--) {
            Last[A[i]] = i;
            for (int j = 0; j < 4; j++) {
                next[i][j] = Last[j];
            }
        }
        return dp(0, N - 1) - 1;
    }

    public int dp(int i, int j) {
        if (meno[i][j] > 0) return meno[i][j];
        int ans = 1;
        if (i <= j) {
            for (int k = 0; k < 4; ++k) {
                int i0 = next[i][k];
                int j0 = prev[j][k];
                if (i <= i0 && i0 <= j) ans++;
                if (-1 < i0 && i0 < j0) ans += dp(i0 + 1, j0 - 1);
                if (ans >= MOD) ans -= MOD;
            }
        }
        meno[i][j] = ans;
        return ans;
    }
    // public int dfs(int start, int end) {
    //     if(start < end) {
    //         return 0;
    //     }
    //     if(meno[start][end] > 0) {
    //         return meno[start][end];
    //     }
    //     int ans = 1;
    //     for(int i = 0; i < 4; i++) {
    //         int first = next[start][i];
    //         int second = prev[end][i];
    //         if(first >= start && first <= end) {
    //             ans++;
    //         }
    //         if(first > -1 && first < second) {
    //             ans += dfs(first + 1, second - 1);
    //         }
    //         if(ans >= MOD) {
    //             ans -= MOD;
    //         }
    //     }
    //     meno[start][end] = ans;
    //     return ans;
    // }
}
