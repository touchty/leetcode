package test;

import java.util.ArrayList;
import java.util.List;

// LC 131. Palindrome Partitioning
// 分割所有的回文子串

public class PalindromePartitioning {
    public boolean[][] buildDp(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] res = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j] && (j - i <= 2 || res[i + 1][j - 1]))
                    res[i][j] = true;
            }
        }
        return res;
    }

    public void helper(String s, boolean[][] dp, List<List<String>> res, List<String> partial, int start, int end) {
        if (start == end) res.add(new ArrayList<>(partial));
        for (int i = start; i < end; i++) {
            if (dp[start][i]) {
                partial.add(s.substring(start, i + 1));
                helper(s, dp, res, partial, i + 1, end);
                partial.remove(partial.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> partial = new ArrayList<>();
        helper(s,buildDp(s),res,partial,0,s.length());
        return res;
    }
}
