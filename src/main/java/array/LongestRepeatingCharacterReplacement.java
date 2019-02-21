package array;

import org.junit.Assert;

/*
424. Longest Repeating Character Replacement
Medium

434

43

Favorite

Share
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int start = 0;
        int end = 0;
        int[] count = new int[26];
        for (end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount == k + 1) {
                --count[s.charAt(start) - 'A'];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int result = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        int expected = 4;
        Assert.assertEquals(expected, result);
    }
}
