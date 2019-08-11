package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int N = in.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
            }

            Arrays.sort(nums);
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < N - 2; i++) {
                double avg = (nums[i] + nums[i + 1] + nums[i + 2]) / (double) 3;
                double var = 0;
                var += Math.pow(nums[i] - avg, 2);
                var += Math.pow(nums[i + 1] - avg, 2);
                var += Math.pow(nums[i + 2] - avg, 2);
                min = Math.min(var, min);
            }
            System.out.printf("%.2f", min);
        }
    }
}
