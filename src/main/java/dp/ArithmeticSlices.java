package dp;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int curr = 0;

        int sum = 0;

        for (int i = 2; i < A.length; i++) {
            // curr = curr + 1
            // curr == 0 means i-1, i-2, i-3 are not Arithmetic Sequences
            // curr != 0 means i -1, i-2 i-3, ...are Arithmetic Sequences, and when i, i-1, i-2
            // are Arithmetic Sequences, we increase curr by 1
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else curr = 0;
        }
        return sum;
    }
}
