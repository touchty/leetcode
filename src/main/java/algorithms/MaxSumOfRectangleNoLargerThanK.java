package algorithms;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null) return 0;
        int row = matrix.length, col = matrix[0].length, res = Integer.MIN_VALUE;
        for (int l = 0; l < col; ++l) {
            int[] sums = new int[row];
            for (int r = l; r < col; ++r) {
                for (int i = 0; i < row; ++i) {
                    sums[i] += matrix[i][r];
                }

                // Find the max subarray no more than K
                TreeSet<Integer> accuSet = new TreeSet<>();
                accuSet.add(0);  // if curSum <= k, the single row is ok;
                int curSum = 0, curMax = Integer.MIN_VALUE;
                for (int sum : sums) {
                    curSum += sum;
                    Integer candidate = accuSet.ceiling(curSum - k); // if curSum <= k, the single row is ok;
                    if (candidate != null) curMax = Integer.max(curMax, curSum - candidate);
                    accuSet.add(curSum);
                }
                res = Integer.max(res, curMax);
            }
        }
        return res;
    }

    public int maxSumSubmatrixOpt(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length, ans = Integer.MIN_VALUE;
        for (int left = 0; left < col; left++) {
            int[] sum = new int[row];
            for (int right = left; right < col; right++) {
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][right];
                }
                TreeSet<Integer> curSums = new TreeSet<Integer>();
                curSums.add(0);
                int curMax = Integer.MIN_VALUE, cum = 0;
                for (int s : sum) {
                    cum += s;
                    Integer val = curSums.ceiling(cum - k);
                    if (val != null) curMax = Math.max(curMax, cum - val);
                    curSums.add(cum);
                }
                ans = Math.max(ans, curMax);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        int k = 2;
        int res = maxSumSubmatrix(matrix, k);
        System.out.println(res);
    }
}
/*
class Solution {
    public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        if (matrix.empty()) return 0;
        int row = matrix.size(), col = matrix[0].size(), res = INT_MIN;
        for (int l = 0; l < col; ++l) {
            vector<int> sums(row, 0);
            for (int r = l; r < col; ++r) {
                for (int i = 0; i < row; ++i) {
                    sums[i] += matrix[i][r];
                }

                // Find the max subarray no more than K
                set<int> accuSet;
                accuSet.insert(0);
                int curSum = 0, curMax = INT_MIN;
                for (int sum : sums) {
                    curSum += sum;
                    set<int>::iterator it = accuSet.lower_bound(curSum - k);
                    if (it != accuSet.end()) curMax = std::max(curMax, curSum - *it);
                    accuSet.insert(curSum);
                }
                res = std::max(res, curMax);
            }
        }
        return res;
    }
};*/
