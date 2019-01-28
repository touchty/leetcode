package bit;

/*
693. Binary Number with Alternating Bits
Easy

267

68

Favorite

Share
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different
values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        // special number
        int prev = 2;
        int curr = 0;
        while (n > 0) {
            curr = n % 2;
            if (curr == prev)
                return false;
            prev = curr;
            n /= 2;
        }
        return true;
    }
}
