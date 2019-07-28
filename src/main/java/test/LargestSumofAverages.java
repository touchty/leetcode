package test;

//813. Largest Sum of Averages
// 将数组分成K部分，求最大的（平均数的和）

public class LargestSumofAverages {
    // 暴力
    double max;

    public double largestSumOfAverages(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = A[i] + sums[i];
        }
        dfs(sums, 0, K, 0);
        return max;
    }

    void dfs(int[] sums, int end, int K, double currSum) {
        if (K < 0 || end >= sums.length)
            return;

        if (K == 0 && end == sums.length - 1) {
            max = Math.max(max, currSum);
            return;
        }

        for (int i = end + 1; i < sums.length; i++) {
            double tempAvg = sums[i] - sums[end];
            tempAvg /= (i - end);
            dfs(sums, i, K - 1, currSum + tempAvg);
        }
    }

    // DP算法
    //search return the result for n first numbers to k groups.
    //It's top-down solution and it keeps all process to memory.
    //So it's like a DP solution while DP is bottom-up.
    //I took suggestion from @MonnaGotIt and added a prunting: if (n < k) return 0;
    public double largestSumOfAveragesDP(int[] A, int K) {
        int N = A.length;
        double[][] memo = new double[N + 1][K + 1];
        double cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += A[i];
            memo[i + 1][1] = cur / (i + 1);
        }
        return search(N, K, A, memo);
    }

    public double search(int n, int k, int[] A, double[][] memo) {
        if (memo[n][k] > 0) return memo[n][k];
        if (n < k) return 0;
        double cur = 0;
        for (int i = n - 1; i > 0; --i) {
            cur += A[i];
            memo[n][k] = Math.max(memo[n][k], search(i, k - 1, A, memo) + cur / (n - i));
        }
        return memo[n][k];
    }


    public static void main(String[] args) {
        int[] A = {9, 1, 2, 3, 9};
        int K = 3;
        LargestSumofAverages solution = new LargestSumofAverages();
        double largest = solution.largestSumOfAverages(A, K);
        System.out.println(largest);

        int[] A1 = {4663, 3020, 7789, 1627, 9668, 1356, 4207, 1133, 8765, 4649, 205, 6455, 8864, 3554, 3916, 5925, 3995, 4540, 3487, 5444,
                8259, 8802, 6777, 7306, 989, 4958, 2921, 8155, 4922, 2469, 6923, 776, 9777, 1796, 708, 786, 3158, 7369, 8715, 2136, 2510,
                3739, 6411, 7996, 6211, 8282, 4805, 236, 1489, 7698};
        int K1 = 27;
        double largest1 = solution.largestSumOfAveragesDP(A1, K1);
        System.out.println(largest1);
    }
}
