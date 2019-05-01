package test;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i + 1] = i + 1;
        }

        for (int i = 0; i < word1.length(); i++) {
            dp[i + 1][0] = i + 1;
        }
        for (int i = 0; i < word1.length(); i++)
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]);
                }
            }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String w1 = "";
        String w2 = "abc";
        int dist = EditDistance.minDistance(w1, w2);
        System.out.println(dist);
    }
}
