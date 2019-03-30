package algorithms;

/*
1012. Complement of Base 10 Integer
Easy

25

8

Favorite

Share
Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.

The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.

For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.



Example 1:

Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 */
public class ComplementofBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int i = 0;
        int res = 0;
        while (N > 0) {
            int last = (N % 2) ^ 1;
            res += last * Math.pow(2, i);
            i++;
            N /= 2;
        }
        return res;
    }

    /*
    Hints
    what is the relationship between input and output
    input + output = 111....11 in binary format
    Is there any corner case?
    0 is a corner case expecting 1, output > input
    Intuition
    Let's find the first number X that X = 1111....1 > N
    And also, it has to be noticed that,
    N = 0 is a corner case expecting1 as result.


    Solution 1:
    N + bitwiseComplement(N) = 11....11 = X
    Then bitwiseComplement(N) = X - N

    Java:
     */
    public int bitwiseComplementOpt(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}
