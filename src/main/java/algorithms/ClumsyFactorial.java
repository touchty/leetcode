package algorithms;

/*
1006. Clumsy Factorial
Medium

29

62

Favorite

Share
Normally, the factorial of a positive integer n is the product of all positive integers less than or equal to n.  For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.

We instead make a clumsy factorial: using the integers in decreasing order, we swap out the multiply operations for a fixed rotation of operations: multiply (*), divide (/), add (+) and subtract (-) in this order.

For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.  However, these operations are still applied using the usual order of operations of arithmetic: we do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.

Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  This guarantees the result is an integer.

Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial of N.



Example 1:

Input: 4
Output: 7
Explanation: 7 = 4 * 3 / 2 + 1
Example 2:

Input: 10
Output: 12
Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 */


/*
Solution:
As defined in the description of problem, Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.

We can easily observe below:

5 * 4 / 3 = 6
6 * 5 / 4 = 7
10 * 9 / 8 = 11
...
...
...

so we can get this formula: i * (i-1) / (i-2) = i+1 when i >= 5

we can simplify our computation as below:

    i * (i-1) / (i-2) + (i-3) - (i-4) * (i-5) / (i-6) + (i-7) - (i-8) * .... + rest elments
=   (i+1) + "(i-3)" - "(i-4) * (i-5) / (i-6)" + "(i-7)" - "(i-8) * " .... + rest elments
=   (i+1) + "(i-3) - (i-3)" + "(i-7) - (i-7)" +  ....  + rest elments
=   (i+1) + rest elments
we can call each 4 numbers a chunk, so from N // 4 we can know how many chunks there are, then the rest 0, 1, 2 and 3 elements will influence our final result.

when 0 element left: final result is (i+1) + ... + 5 - (4*3/2) + 1, which is i+1
when 1 element left: final result is (i+1) + ... + 6 - (5*4/3) + 2 - 1, which is i+2
when 2 element left: final result is (i+1) + ... + 7 - (6*5/4) + 3 - 2 * 1, which is i+2
when 3 element left: final result is (i+1) + ... + 8 - (7*6/5) + 4 - 3 * 2 / 1, which is i-1
 */
public class ClumsyFactorial {
    public int clumsy(int N) {
        int[] magic = new int[]{1, 2, 2, -1, 0, 0, 3, 3};
        return N + ((N > 4) ? magic[N % 4] : magic[N + 3]);
    }
}
