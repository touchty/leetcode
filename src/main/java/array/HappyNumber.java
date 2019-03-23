package array;

import org.junit.Assert;

/**
 * 202. Happy Number
 * Easy
 * <p>
 * 718
 * <p>
 * 167
 * <p>
 * Favorite
 * <p>
 * Share
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

/*
Solution:
I see the majority of those posts use hashset to record values. Actually, we can simply adapt the Floyd Cycle detection
algorithm. I believe that many people have seen this in the Linked List Cycle detection problem. The following is my
code:
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitalSquareSum(slow);
            fast = digitalSquareSum(fast);
            fast = digitalSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    int digitalSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 145;
        HappyNumber happyNumber = new HappyNumber();
        boolean res = happyNumber.isHappy(n);
        boolean expected = true;
        Assert.assertEquals(expected, res);
    }
}
