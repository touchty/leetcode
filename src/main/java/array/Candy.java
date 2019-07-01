package array;

import org.junit.Assert;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Example 1:
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int total = 1; // total candies allocated
        int prev = 1; // number of previous child's candy
        int countDown = 0; // number of descending array (exclusive of the first or peek child)

        // start from the second child, the first is allocated with 1 canndy.
        for (int i = 1; i < ratings.length; i++) {
            // ascending order
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) { // descending is longer than peek
                        total += countDown - prev + 1;
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else {
                countDown++;
            }
        }
        if (countDown > 0) {
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) { // descending is longer than peek
                total += countDown - prev + 1;
            }
        }

        return total;
    }

    public static int candyOpt(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int[] nums = new int[ratings.length];
        Arrays.fill(nums, 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (ratings[i + 1] > ratings[i])
                nums[i + 1] = nums[i] + 1;
        }
        int total = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                nums[i] = Math.max(nums[i], nums[i + 1] + 1);
            }
            total += nums[i];
        }
        total += nums[nums.length - 1];
        return total;
    }

    public static void main(String[] args) {
        int[] ratings = {3, 2, 1, 0, 1, 2, 2, 2, 2, 2};
        // ratings {3,2,1,0,1,2,2,2,2,2}
        // candies {4,3,2,1,2,3,1,1,1,1}
        // note the last four candies are '1'
        int res = candy(ratings);
        int resOpt = candyOpt(ratings);
        int expected = 19;
        Assert.assertEquals(expected, res);
        Assert.assertEquals(expected, resOpt);
    }
}
