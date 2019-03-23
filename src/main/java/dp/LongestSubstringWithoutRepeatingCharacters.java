package dp;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int end = 0;
        int counter = 0;
        int[] map = new int[128];
        int d = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]++ > 0) counter++;

            while (counter > 0) {
                if (map[s.charAt(head++)]-- > 1) counter--;
            }

            d = Math.max(d, end - head);
        }

        return d;
    }
}
