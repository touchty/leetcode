package array;

import org.junit.Assert;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int counter = 0, begin = 0, end = 0, d = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0) counter++;
            while (counter > 2) if (map[s.charAt(begin++)]-- == 1) counter--;
            d = Math.max(d, end - begin);
        }
        return d;
    }

    public static void main(String[] args) {
        String str = "abcbbbbcccbdddadacb";

        int result = LongestSubstringWithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct(str);

        int expected = 10;

        Assert.assertEquals(result, expected);
    }
}
