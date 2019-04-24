package dp;

/*
72. Edit Distance
Hard

1951

29

Favorite

Share
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // +1是为了从len=0的字符串算起
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // dp二维数组的初始化
        dp[0][0] = 0;
        for (int i = 1; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        // dp的关系递推
        for (int i = 1; i < word1.length() + 1; i++)
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j] + 1 删除w1 i-1
                    // dp[i][j-1] + 1 w1插入对应的字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

    }
}
