package array;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int i = 0; i <= n; i++)
            dp[0][i] = i;

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[m][n];
    }

    public int minDistanceOpt(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] cur = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            cur[i] = i;
        }

        for (int j = 1; j <= n; j++) {
            int prev = cur[0];
            cur[0] = j;
            for (int i = 1; i <= m; i++) {
                int temp = cur[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[i] = prev;
                else
                    cur[i] = Math.min(prev, Math.min(cur[i - 1], cur[i])) + 1;
                prev = temp;
            }
        }
        return cur[m];
        ////
        //prev cur[i-1]
        //temp  cur[i]
    }


        public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        EditDistance editDistance = new EditDistance();
        int result = editDistance.minDistanceOpt(word1, word2);
        System.out.println(result);
    }
}
