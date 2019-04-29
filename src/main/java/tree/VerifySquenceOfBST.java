package tree;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return isSequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean isSequenceOfBST(int[] sequence, int start, int end) {
        if (end - start < 2)
            return true;
        int mid = sequence[end];
        int index = start;
        while (sequence[index] < mid)
            index += 1;
        int j = index;
        while (j < end) {
            if (sequence[j] < mid)
                return false;
            j += 1;
        }
        return isSequenceOfBST(sequence, start, index - 1) && isSequenceOfBST(sequence, index, end - 1);
    }

    public static void main(String[] args) {
        int[] potential = {1, 2, 8};
        VerifySquenceOfBST solution = new VerifySquenceOfBST();
        boolean res = solution.VerifySquenceOfBST(potential);
        System.out.println(res);
    }
}
