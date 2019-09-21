package HRQuestion.wangyi3;

import java.util.Scanner;

public class Q4 {
    static long reverseSum(int[] nums) {
        long dists = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    dists += (j - i);
                }
            }
        }
        return dists;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(reverseSum(nums));
    }
}
