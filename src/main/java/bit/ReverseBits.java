package bit;

import org.junit.Assert;

/**
 * 190. Reverse Bits
 * Easy
 * <p>
 * 446
 * <p>
 * 128
 * <p>
 * Favorite
 * <p>
 * Share
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so
 * return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so
 * return 3221225471 which its binary representation is 10101111110010110010011101101001.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String binaryBits = "00000010100101000001111010011100";
        System.out.println(binaryBits);
        int n = Integer.parseInt(binaryBits, 2); // parse base 2
        int res = ReverseBits.reverseBits(n);
        // convert int to 32 bits
        // add a leading bit '1' to right. convert to long. get first 33 bits. get substring from 1 to 33.
        // String result = Long.toBinaryString( Integer.toUnsignedLong(sID) | 0x100000000L ).substring(1);
        String reversedBinaryBits = Long.toBinaryString(res & 0xffffffffL | 0x100000000L).substring(1);
        System.out.println(reversedBinaryBits);
        String reversedReversed = new StringBuilder(reversedBinaryBits).reverse().toString();
        System.out.println(reversedReversed);
        Assert.assertEquals(binaryBits, reversedReversed);
    }
}
