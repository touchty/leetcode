package test;

public class LongestNoRepeatSubString {

    static int longest(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int alpha = 256;
        int[] counts = new int[26];
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < str.length()) {
            counts[str.charAt(right) - 'a']++;
            if (counts[str.charAt(right) - 'a'] == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                while (counts[str.charAt(right) - 'a'] != 1) {
                    counts[str.charAt(left) - 'a']--;
                    left++;
                }
            }
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str1 = "abcabcab";
        int longest1 = LongestNoRepeatSubString.longest(str1);
        System.out.println(longest1);
    }
}
