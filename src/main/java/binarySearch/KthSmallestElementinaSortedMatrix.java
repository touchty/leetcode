package binarySearch;

public class KthSmallestElementinaSortedMatrix {
    int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[n - 1][m - 1];
        int mid = 0;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            int num = 0;
            for (int i = 0; i < n; i++)  // row
            {
                int Lo = -1, Hi = m - 1;  // column
                while (Hi > Lo) {
                    int MID = (Lo + Hi + 1) / 2;
                    if (matrix[i][MID] > mid)
                        Hi = MID - 1;
                    else
                        Lo = MID;
                }
                num += Lo + 1;
            }
            if (num < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    // another solution
    public int kthSmallestII(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length;
        for (int i = n - 1, j = 0; i >= 0 && j < n; ) {
            if (matrix[i][j] > val)
                i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
