package test;

/*
41. First Missing Positive
第一个最小的正数
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i)
            // 把数字放到对应位置，注意循环！
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1)
                return i + 1;
            i++;
        }

        return n + 1;
    }

    void rearrange(int[] A) {
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            while (A[i] >= 1 && A[i] <= n && A[i] != i + 1) {
                int t = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 2, 4, 6, 11, 12};
        FirstMissingPositive s = new FirstMissingPositive();
        s.firstMissingPositive(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
