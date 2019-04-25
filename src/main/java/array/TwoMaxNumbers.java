package array;

public class TwoMaxNumbers {
    static int[] maxTwo(int[] arr) {
        int[] res = {0, 0};
        int Max = Integer.MIN_VALUE;
        int Next = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > Max) {
                Next = Max;
                Max = i;
            } else if (i > Next) {
                Next = i;
            }
        }
        res[0] = Max;
        res[1] = Next;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1};
        int[] top2 = maxTwo(arr);
        for (int i : top2)
            System.out.println(i);
    }
}
