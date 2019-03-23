package stack;

import org.junit.Assert;

/**
 * 856. Score of Parentheses
 * Medium
 * <p>
 * 416
 * <p>
 * 19
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 */
public class ScoreOfParentheses {
    public static int scoreOfParentheses(String S) {
        int res[] = new int[30], i = 0;
        for (char c : S.toCharArray())
            if (c == '(') res[++i] = 0;
            else res[i - 1] += Math.max(res[i--] * 2, 1);
        return res[0];
    }

    //Follow-up:
    //Can you solve it in O(1) space?
    //count layer and the score is 1 << (layers - 1).
    public int scoreOfParenthesesOpt(String S) {
        int res = 0, layers = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') layers++;
            else layers--;
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') res += 1 << (layers - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"()", "(())"};
        int real = ScoreOfParentheses.scoreOfParentheses(strs[0]);
        int expected = 1;
        Assert.assertEquals(expected, real);

        real = ScoreOfParentheses.scoreOfParentheses(strs[1]);
        expected = 2;
        Assert.assertEquals(expected, real);
    }
}
