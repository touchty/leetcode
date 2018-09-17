package array;

public class ImageOverlap {
    private int countOverlap(int[][] A, int[][] B, int xmove, int ymove, int xoverlap, int yoverlap) {
        int res = 0;
        for (int i = 0; i < xoverlap; ++i)
            for (int j = 0; j < yoverlap; ++j)
                if (A[i][j] + B[i + xmove][j + ymove] == 2) ++res;
        return res;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int res = 0;

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                int cur = countOverlap(A, B, i, j, A.length - i, B.length - j);
                res = Math.max(res, cur);
                cur = countOverlap(B, A, i, j, B.length - i, A.length - j);
                res = Math.max(res, cur);
            }
        }

        return res;
    }
}
