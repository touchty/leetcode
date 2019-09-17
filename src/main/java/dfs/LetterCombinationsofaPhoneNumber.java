package dfs;

import java.util.ArrayList;
import java.util.List;

// LC 17. Letter Combinations of a Phone Number
// 电话盘
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        String[] s = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        helper(s, res, new StringBuilder(), digits);
        // helperII(s, res, new StringBuilder(), digits, 0);
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

    private void helperII(String[] s, List<String> res, StringBuilder sb, String digits, int pos) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
        if (s[pos].length() == 0) {
            helperII(s, res, sb, digits, pos + 1);
        } else {
            for (int i = 0; i < s[pos].length(); i++) {
                sb.append(s[pos].charAt(i));
                helperII(s, res, sb, digits, pos + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "012";
        LetterCombinationsofaPhoneNumber solution = new LetterCombinationsofaPhoneNumber();
        System.out.println(solution.letterCombinations(digits));
    }
}
