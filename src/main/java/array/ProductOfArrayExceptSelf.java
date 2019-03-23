package array;

import org.junit.Assert;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] toLeft = new int[n];

        int[] toRight = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                toLeft[0] = nums[0];
                toRight[n - 1] = nums[n - 1];
            } else {
                toLeft[i] = nums[i] * toLeft[i - 1];
                toRight[n - 1 - i] = nums[n - 1 - i] * toRight[n - i];
            }

        }

        int[] res = new int[n];
        for (int i = 1; i < n - 1; i++) {
            res[i] = toLeft[i - 1] * toRight[i + 1];
        }
        res[0] = toRight[1];
        res[n - 1] = toLeft[n - 2];

        return res;
    }

    public static int[] productExceptSelfOpt(int[] nums) {

        int temp = 1;
        int len = nums.length;
        int prod[] = new int[len];

        for (int i = 0; i < len; i++) {
            prod[i] = 1;
        }

        for (int i = 0; i < len; i++) {
            prod[i] = temp;
            temp = nums[i] * temp;
        }

        temp = 1;

        for (int i = len - 1; i >= 0; i--) {
            prod[i] = temp * prod[i];
            temp = temp * nums[i];
        }

        return prod;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] res = ProductOfArrayExceptSelf.productExceptSelfOpt(nums);
        int[] expected = new int[]{24, 12, 8, 1};
        Assert.assertArrayEquals("Error", res, expected);
    }
}
