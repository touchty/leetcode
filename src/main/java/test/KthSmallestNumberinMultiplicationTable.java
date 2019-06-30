package test;

// LC 668. Kth Smallest Number in Multiplication Table

// 在元素周期表中查找第K个元素
// 解法：猜测第K个元素的值
/*
Input: m = 3, n = 3, k = 5
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6
3	6	9
The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 */
public class KthSmallestNumberinMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c < k) low = mid + 1;
            else high = mid;
        }

        return high;
    }

    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int eleInRow = Math.min(v / i, n);
            count += eleInRow;
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int K = 5;
        KthSmallestNumberinMultiplicationTable solution = new KthSmallestNumberinMultiplicationTable();
        int kth = solution.findKthNumber(m, n, K);
        System.out.println(kth);
    }
}
