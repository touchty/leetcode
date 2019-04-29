package test;

/*
连续的有效括号序列！！！
32. Longest Valid Parentheses
Hard

1733

83

Favorite

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) return 0;
        int[] longest = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') longest[i] = 0;
            else if (s.charAt(i - 1) == '(') {
                if (i >= 2)
                    longest[i] = longest[i - 2] + 2;
                else longest[i] = 2;
            } else {
                if (i >= longest[i - 1] + 1 && s.charAt(i - longest[i - 1] - 1) == '(') {
                    longest[i] = longest[i - 1] + 2;
                    if (i >= longest[i - 1] + 2)
                        longest[i] += longest[i - longest[i - 1] - 2];
                }
            }
            max = Math.max(max, longest[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        int expected = 4;
        LongestValidParentheses solution = new LongestValidParentheses();
        int res = solution.longestValidParentheses(s);
        System.out.println(res);
    }
}
