package test;

public class VarifyPost {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isV(sequence, 0, sequence.length - 1);
    }

    static boolean isV(int[] sequence, int i, int j) {
        if (i >= j)
            return true;
        int k = i;
        while (k < j) {
            if (sequence[k] < sequence[j])
                k++;
            else {
                break;
            }
        }
        for (int p = k; p < j; p++) {
            if (sequence[p] < sequence[j])
                return false;
        }


        return isV(sequence, i, k - 1) && isV(sequence, k, j - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(VerifySquenceOfBST(nums));
    }
}
