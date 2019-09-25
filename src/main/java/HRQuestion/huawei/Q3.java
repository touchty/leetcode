package HRQuestion.huawei;

import java.util.Scanner;

public class Q3 {
    static final int N = 100001;

    static int[] result(int[] nums) {
        int[] arr = new int[N];
        arr[nums[0]]++;
        int prev = 0;
        int max = Integer.MIN_VALUE;
        int temp = prev;
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int less = 0;
            for (int j = 1; j < val; j++) {
                less += arr[j];
            }
            int more = 0;
            for (int j = val + 1; j < N; j++) {
                more += arr[j];
            }
            temp = prev + less - more;
            max = Math.max(temp, max);
            prev = temp;
            arr[val]++;
        }

        return new int[]{max, prev};
    }



    public static void main(String[] args) {
        /*int[] nums = {2, 1, 3};
        int[] res = result(nums);
        System.out.println(res[0] + " " + res[1]);*/

        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.valueOf(scanner.nextLine());
            String nVals = scanner.nextLine();
            String[] valstr = nVals.split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.valueOf(valstr[j]);
            }
            int[] result = result(nums);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}

/*
2
3
1 3 2
3
2 1 3
 */
