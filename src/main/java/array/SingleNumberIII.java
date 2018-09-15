package array;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}

/*
 Why diff &= ~(diff - 1)
 First, this the original formula to get the last set bit. The diff &= -diff is just an abbreviation with the knowledge of ~(diff - 1) = - (diff - 1) - 1 = -diff.

 If diff is set on the least significant bit, then this is trivially provable: the least significant bit is the last set bit. After the -1 operation, this least significant bit became 0, and is the only change to all bits of diff. Then we ~ the result, which means the least significant bit gets reverted to 1, while all the other bits are guaranteed to have been reverted. Thus the least significant bit is the only bit that is left unchanged and that could survive the & operation.
 If diff is unset on the least significant bit: let's focus on the rightmost occurrence of 10 in diff. The 1 bit in this 10 is the last set bit of diff. After -1 operation, this 10 becomes 01. All the 0 bits to the right of this rightmost 10 are all change to 1 bits, and all the other whatever bits to the left of this rightmost 10 would be remain unchanged:
 **..**10_00..00
 after -1:
 **..**01_11..11
 Then we do ~ operation. The **..** part would all be reverted, and none of them would survive the upcoming & operation. 01 would become back 10, and would both survive the & operation, although the bit 1 is the only one we care about. All those 11..11 part gets reverted back to 00..00 after the ~ operation, and does not matter to the & operation. Thus the only thing surviving the & operation would be the rightmost 10, or the last set bit which is within it.

 Incidentally, it does not really matter which bit we choose for the second pass to succeed, but since there is an elegant way to find the rightmost set bit, then let's use that.
 */