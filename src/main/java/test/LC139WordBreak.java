package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && set.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        boolean canBreak = wordBreak(s, Arrays.asList(wordDict));
        System.out.println(canBreak);
    }
}
