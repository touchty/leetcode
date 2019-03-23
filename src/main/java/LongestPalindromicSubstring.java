public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s, i, j)) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        left = i;
                        right = j;
                        //System.out.printf("max " + max);
                    }
                }
            }
        //System.out.printf("left right" + left + " " + right);
        return s.substring(left, right + 1);
    }

    boolean isPalindromic(String s, int left, int right) {
        boolean result = true;
        for (int i = 0; i <= (right - left) / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i))
                result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        String sample = "babad";
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        String substr = l.longestPalindrome(sample);
        System.out.printf(substr);
    }
}
