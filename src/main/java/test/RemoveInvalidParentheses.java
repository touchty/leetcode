package test;

import java.util.ArrayList;
import java.util.List;

/*
删除括号，使剩余的合法，而且最长
301. Remove Invalid Parentheses
Hard

1271

53

Favorite

Share
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
            }
            return;
        }

        String rev = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(rev, ans, 0, 0, new char[]{')', '('});
        } else
            ans.add(rev);
    }

    public static void main(String[] args) {
        String s = "()))";
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        List<String> list = solution.removeInvalidParentheses(s);
        System.out.println(list);
    }
}
