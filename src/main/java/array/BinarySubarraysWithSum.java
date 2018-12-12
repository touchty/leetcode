package array;

import org.junit.Assert;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int res = 0;
        int[] count = new int[A.length + 1];
        // count[pSum] : pSum is the sum from A[0] to A[i] (i is any number from 0 to A.length)
        // count[pSum] means how many i meet this requirement.
        // count[0] is always 1, which means we don not choose any of the elements.
        count[0] = 1;
        int pSum = 0;

        for (int a : A) {
            pSum += a;
            if (pSum >= S)
                res += count[pSum - S];
            count[pSum]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,0,1,0,1};
        int S = 2;
        int actual = new BinarySubarraysWithSum().numSubarraysWithSum(A, S);
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
}
