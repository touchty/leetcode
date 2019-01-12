package dp;

import org.junit.Assert;

/**
 * 664. Strange Printer
 * Hard
 * <p>
 * 211
 * <p>
 * 28
 * <p>
 * Favorite
 * <p>
 * Share
 * There is a strange printer with the following two special requirements:
 * <p>
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any places, and will cover the
 * original existing characters.
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer
 * needed in order to print it.
 * <p>
 * Example 1:
 * Input: "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 * Input: "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 */
public class StrangePrinter {
    public static int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[101][101];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = i + 1;
                for (int k = j + 1; k <= j + i; k++) {
                    int temp = dp[j][k - 1] + dp[k][j + i];
                    // The core argument here is that you can save one step every time you concatenate two strings
                    // together that have the same ending character.
                    // "aba" : in terms of "a" and "ba",  we can save one step
                    //
                    // right substring and left substring have the same ending character:
                    // "(........a)(...............a)": if the left substring consists of only 'a', such as "aaaaaaaa",
                    // then there is no need to print the left substring, because we can do it in right substring.
                    // if the left substring consists of not only 'a' , such as "cdrfa", then we donn't need to print
                    // the ending "a", because we can do it in the right substring.
                    // no matter what is the case, we can subtract 1 when combining
                    if (s.charAt(k - 1) == s.charAt(j + i)) temp--;
                    dp[j][j + i] = Math.min(dp[j][j + i], temp);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "aba";
        int res = StrangePrinter.strangePrinter(s);
        int expected = 2;
        Assert.assertEquals(res, expected);

        s = "aaabbb";
        res = StrangePrinter.strangePrinter(s);
        expected = 2;
        Assert.assertEquals(res, expected);
        System.out.println("Tests passes.");
    }
}