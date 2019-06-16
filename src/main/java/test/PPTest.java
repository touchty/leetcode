package test;

import java.util.ArrayList;
import java.util.List;

public class PPTest {
    public boolean[][] buildDp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i -j <= 2 || dp[j+1][i-1]))
                    dp[j][i] = true;
            }
        }
        return dp;
    }

    void dfs(String s, int start, List<String> tempList, List<List<String>> res, boolean[][] isP) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        else {
            for (int i = start; i < s.length(); i++) {
                if (isP[start][i]) {
                    tempList.add(s.substring(start, i+1));
                    dfs(s, i + 1, tempList, res, isP);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] isP = buildDp(s);
        dfs(s, 0, new ArrayList<>(), res, isP);
        return res;
    }

    public static void main(String[] args) {
        String s = "aab";
        PPTest solution = new PPTest();
        List<List<String>> res = solution.partition(s);
        for (List<String> list : res)
            System.out.println(list);
    }
}
