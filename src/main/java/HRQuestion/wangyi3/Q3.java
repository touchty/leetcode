package HRQuestion.wangyi3;

import java.util.Scanner;

/*
完美序列
连续子序列，满足当前元素大于等于前缀和
 */
public class Q3 {
    static void ADD(int[] res, int sum) {
        int result = 0;
        for (int i = 0; i < sum; i++) {
            for (int j = i + 1; j < sum; j++) {
                if (res[i] > res[j]) {
                    result += (j - i);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        ADD(nums, N);
    }
}
