package dfs;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        String[] s = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        helper(s, res, new StringBuilder(), digits);
        return res;
    }

    private void helper(String[] s, List<String> res, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            String str = new String(sb);
            res.add(str);
            return;
        }

        char[] ch = s[digits.charAt(sb.length()) - '0'].toCharArray();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
            helper(s, res, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
