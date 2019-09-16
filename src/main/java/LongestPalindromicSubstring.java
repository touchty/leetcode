import java.util.Scanner;

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

    private int lo = 0;
    private int maxLen = 0;

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public String longestP(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, maxLen);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String sample = in.next();
            LongestPalindromicSubstring l = new LongestPalindromicSubstring();
            String substr = l.longestPalindrome(sample);
            System.out.println(substr);

        }

    }
}
