package test;

// 三分查找
public class Ternarysearch {
    int ternarySearch(int[] A, int left, int right) {
        if (left > right) return -1;
        if (left == right) return left;
        if (right - left + 1 <= 3) {
            int max = left;
            for (int i = left + 1; i <= right; i++) {
                if (A[i] > A[max]) max = i;
            }
            return max;
        }
        // l, p1, p2, r
        int p1 = (2 * left + right) / 3;
        int p2 = (left + 2 * right) / 3;

        if (A[p2] > A[p1]) return ternarySearch(A, p1, right);
        else return ternarySearch(A, left, p2);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 4, 3, 2, 1};
        int[] A1 = {1, 2};
        int pos = new Ternarysearch().ternarySearch(A, 0, A.length - 1);
        if (pos >= 0)
            System.out.println(A[pos]);
    }
}
