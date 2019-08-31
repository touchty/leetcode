package HRQuestion;

import java.util.Scanner;

public class Q360_2_2 {
    public static int maxEndPoints(int[] nums) {
        int res = nums.length;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(N);
        }

    }
}
