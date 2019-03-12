package binarySearch;

/*
668. Kth Smallest Number in Multiplication Table
Hard

281

18

Favorite

Share
Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 */
public class KthSmallestNumberinMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low = 1 , high = m * n + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) high = mid;
            else low = mid + 1;
        }

        return high;
    }

    int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i , n);
            count += temp;
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int k = 6;
        KthSmallestNumberinMultiplicationTable table =
                new KthSmallestNumberinMultiplicationTable();
        int res = table.findKthNumber(m, n, k);
        System.out.println(res);
    }
}
