package array;

/*
670. Maximum Swap
Medium

Share
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
 */
public class MaximumSwap {
    public static int maximumSwap(int num) {
        String numsStr = "" + num;
        int i = 0;
        int ii = i + 1;
        boolean v = false;
        while (i < numsStr.length() && ii < numsStr.length()) {

            if (numsStr.charAt(ii) > numsStr.charAt(i)) {
                v = true;
                break;
            }

            if (numsStr.charAt(ii) == numsStr.charAt(i)) {
                ii++;
            }
            else {
                i = ii;
                ii++;
            }
        }
        if (!v)
            return num;
        int max = i; // or int max = ii - 1;
        for (int j = i; j <  numsStr.length(); j++) {
            max = numsStr.charAt(max) > numsStr.charAt(j) ? max : j;
        }
        int k = 0;
        for (; k < i; k++) {
            if (numsStr.charAt(k) < numsStr.charAt(max))
                break;
        }
        StringBuilder builder = new StringBuilder(numsStr);
        builder.setCharAt(k, numsStr.charAt(max));
        builder.setCharAt(max, numsStr.charAt(k));
        String newIntStr = builder.toString();
        return Integer.parseInt(newIntStr);
    }

    public int maximumSwapOpt(int num) {
        char max = '0'; int i = 0, maxPos = -1;
        char[] s = Integer.toString(num).toCharArray();
        // Find the first non-descendant integer with index i within which the array from 0 to i
        // is not possible to get the maximum by swapping any digits.
        while (i + 1 < s.length && s[i] >= s[i + 1]) {
            i ++;
        }
        // Find the maximum from the array from i + 1 to the nums.length to find the optimal digit,
        //and take the duplicate digits with maximum, and we always pick the last one here.
        for (int j = i + 1; j < s.length; j ++) {
            if (s[j] >= max) {
                max = s[j];
                maxPos = j;
            }
        }
        // Find the digit pos in the first part just right smaller than the max
        for (int k = 0; k <= i; k ++) {
            if (s[k] < max) {
                char tmp = s[k];
                s[k] = s[maxPos];
                s[maxPos] = tmp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(s));
    }

    public static void main(String[] args) {
        int num = 99901;
        System.out.println(MaximumSwap.maximumSwap(num));
    }
}
