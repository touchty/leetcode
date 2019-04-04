package array;

import org.junit.Assert;

/*
866. Prime Palindrome
Medium
Find the smallest prime palindrome greater than or equal to N.

Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

For example, 2,3,5,7,11 and 13 are primes.

Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

For example, 12321 is a palindrome.



Example 1:

Input: 6
Output: 7
Example 2:

Input: 8
Output: 11
Example 3:

Input: 13
Output: 101
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {
        //  All palindrome with even digits is multiple of 11.
        // So the result is 11 or an even length number
        if (8 <= N && N <= 11) return 11;
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 13;
        PrimePalindrome solution = new PrimePalindrome();
        int nextPalindrome = solution.primePalindrome(n);
        int expected = 101;
        Assert.assertEquals(expected, nextPalindrome);
    }
}
