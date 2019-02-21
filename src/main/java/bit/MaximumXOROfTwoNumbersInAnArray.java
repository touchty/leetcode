package bit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
421. Maximum XOR of Two Numbers in an Array
Medium

595

134

Favorite

Share
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
 */

/*
This idea comes easily if another problem is solved before which is - "Find maximum AND value pair in an array"

Here is a simulation of the algorithm:

Mask   = 00000
Result = 00000

For position 4,
Mask = 10000

Integers    Mask      Modified Integer
--------------------------------------
 3 = 00011 & 10000 =  00000
10 = 01010 & 10000 =  00000
 5 = 00101 & 10000 =  00000
25 = 11001 & 10000 =  10000
 2 = 00010 & 10000 =  00000
 8 = 01000 & 10000 =  00000
--------------------------------------
DesiredResult = Result | (1 << 4) = 10000
DesiredResult ^ 00000 = 10000 <- which is available in array. stop! (DesiredResult = 00000 ^ 10000)
Result = DesiredResult = 10000

For position 3,
Mask   = 11000

Integers    Mask      Modified Integer
--------------------------------------
 3 = 00011 & 11000 =  00000
10 = 01010 & 11000 =  01000
 5 = 00101 & 11000 =  00000
25 = 11001 & 11000 =  11000
 2 = 00010 & 11000 =  00000
 8 = 01000 & 11000 =  01000
--------------------------------------
DesiredResult = Result | (1 << 3) = 11000
DesiredResult ^ 00000 = 11000 <- which is available in array. stop!
Result = DesiredResult = 11000

For position 2,
Mask   = 11100

Integers    Mask      Modified Integer
--------------------------------------
 3 = 00011 & 11100 =  00000
10 = 01010 & 11100 =  01000
 5 = 00101 & 11100 =  00100
25 = 11001 & 11100 =  11000
 2 = 00010 & 11100 =  00000
 8 = 01000 & 11100 =  01000
--------------------------------------
DesiredResult = Result | (1 << 2) = 11100
DesiredResult ^ 00000 = 11100
DesiredResult ^ 01000 = 10100
DesiredResult ^ 00100 = 11000 <- which is available in array. stop!
Result = DesiredResult = 11100

For position 1,
Mask   = 11110

Integers    Mask      Modified Integer
--------------------------------------
 3 = 00011 & 11110 =  00010
10 = 01010 & 11110 =  01010
 5 = 00101 & 11110 =  00100
25 = 11001 & 11110 =  11000
 2 = 00010 & 11110 =  00010
 8 = 01000 & 11110 =  01000
--------------------------------------
DesiredResult = Result | (1 << 1) = 11110
DesiredResult ^ 00010 = 11100
DesiredResult ^ 01010 = 10100
DesiredResult ^ 00100 = 11010
DesiredResult ^ 00010 = 11100
DesiredResult ^ 00100 = 11010
This time Result isn't updated

For position 0,
Mask   = 11111

Integers    Mask      Modified Integer
--------------------------------------
 3 = 00011 & 11111 =  00011
10 = 01010 & 11111 =  01010
 5 = 00101 & 11111 =  00101
25 = 11001 & 11111 =  11001
 2 = 00010 & 11111 =  00010
 8 = 01000 & 11111 =  01000
--------------------------------------
DesiredResult = Result | (1 << 0) = 11101
DesiredResult ^ 00011 = 11110
DesiredResult ^ 01010 = 10110
DesiredResult ^ 00101 = 11000
DesiredResult ^ 11001 = 00100
DesiredResult ^ 00010 = 11111
DesiredResult ^ 01000 = 10101
This time Result isn't updated

Finally, Result = 11100 = 28
 */
public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
            set.clear();
        }
        return max;
    }

    /*
    Suppose A <= C <= B

Then either A XOR C or C XOR B are smaller than A XOR B

Proof:

Let

A=169, B=187, C=185

A= 160 = 1010 1001
B= 187 = 1011 1011
C= 185 = 1011 1001

Let i be the leftmost (biggest) index such that A[i] differs from B[i]. There are 2 cases now:
1) C[i] = A[i] = 0,
then (A XOR C)[i] = 0 and (A XOR B)[i] = 1
This implies (A XOR C) < (A XOR B)
2) C[i] = B[i] = 1,
then (B XOR C)[i] = 0 and (A XOR B)[i] = 1
This implies (B XOR C) < (A XOR B)
     */
    // Function to find minimum XOR pair
    static int minXOR(int arr[], int n) {
        // Sort given array
        Arrays.parallelSort(arr);

        int minXor = Integer.MAX_VALUE;
        int val = 0;

        // calculate min xor of consecutive pairs
        for (int i = 0; i < n - 1; i++) {
            val = arr[i] ^ arr[i + 1];
            minXor = Math.min(minXor, val);
        }

        return minXor;
    }

    // Utility function to check number of elements
    // having set msb as of pattern
    static int checkBit(int pattern, int arr[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }

    // Function for finding maximum and value pair
    static int maxAND(int arr[], int n) {
        int res = 0, count;

        // iterate over total of 30bits
        // from msb to lsb
        for (int bit = 31; bit >= 0; bit--) {
            // find the count of element
            // having set msb
            count = checkBit(res | (1 << bit), arr, n);

            // if count >= 2 set particular
            // bit in result
            if (count >= 2)
                res |= (1 << bit);
        }

        return res;
    }

}
