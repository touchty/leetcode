package array;

import java.util.Arrays;
import java.util.Random;

/*
https://leetcode.com/problems/random-pick-with-weight/discuss/154772/C%2B%2B-concise-binary-search-solution
528. Random Pick with Weight
Medium

188

289

Favorite

Share
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example:
{1,99} 1 % 100 and 99 % 100
 */
public class RandomPickwithWeight {
    int[] sums;
    public RandomPickwithWeight(int[] w) {
        int len = w.length;
        sums = new int[len];
        // sums must be in ascending order because w[i] > 0
        for (int i = 0; i < len;i++) {
            sums[i] = (i == 0 ? 0 : sums[i - 1]) + w[i];
        }
    }

    public int pickIndex() {
        if (sums != null && sums.length != 0) {
            int m = sums[sums.length - 1];
            Random random = new Random();
            int randInt = random.nextInt(m);
            // next greater element in sums
            // the probability is appropriate to the range between two adjacent elements
            int index = Arrays.binarySearch(sums, randInt);
            if (index >= 0)
                index++;
            else
                index = -1 * (index + 1);
            return index;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] w = {3, 14, 1, 7};
        RandomPickwithWeight pickwithWeight = new RandomPickwithWeight(w);
        for (int i = 0; i < 20; i++) {
            System.out.println(pickwithWeight.pickIndex());
        }
    }
}
