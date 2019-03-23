package array;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public int helper(char[] chs, int left, int right, int k) {
        if (right - left < k)
            return 0;
        int[] cnt = new int[26];
        for (int i = left; i < right; i++)
            cnt[chs[i] - 'a']++;

        for (int i = left; i < right; i++) {
            // break;
            if (cnt[chs[i] - 'a'] < k) {
                int j = i + 1;
                while (j < right && cnt[chs[j] - 'a'] < k)
                    j++;
                return Math.max(helper(chs, left, i, k), helper(chs, j, right, k));
            }
        }
        return right - left;
    }
}
