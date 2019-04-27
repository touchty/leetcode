package test;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length <= 0)
            return 0;

        int i = 0;
        int j = 0;
        int c0 = 0;
        int c1 = 0;
        int max = 0;
        while (j < A.length) {
            if (A[j] == 1) c1++;
            if (A[j] == 0) c0++;
            // if (j - i + 1 - c1 <= K || j - i + 1 - c0 <= K) consecutive 0s or 1s
            if (j - i + 1 - c1 <= K) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                if (A[i] == 0) c0--;
                else c1--;
                j++;
                i++;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] A3 = {0,0,0,0};
        int K3 = 0;
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        int res = s.longestOnes(A, 2);
        int res1 = s.longestOnes(A1, 3);
        int res3 = s.longestOnes(A3, K3);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res3);
    }
}
