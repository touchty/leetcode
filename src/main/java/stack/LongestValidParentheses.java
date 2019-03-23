package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }

        if (stack.isEmpty()) return len;
        else {
            int a = len;
            int b = a;
            int longest = 0;

            // max substring
            while (!stack.isEmpty()) {
                b = stack.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            // 0 ... a - 1
            longest = Math.max(longest, a);
            return longest;
        }
    }

    /**
     * non stack
     *
     * @param s
     */
    public static int longestValidParenthesesOpt(String s) {
        int[] longest = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') longest[i] = 0;
            else if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                if (i > 1) longest[i] = longest[i - 2] + 2;
                else longest[i] = 2;
            } else {
                // ( ... ) i and i - longest[i-1] - 1 must match
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
        String str = ")()())";
        int result = LongestValidParentheses.longestValidParentheses(str);
        System.out.println(result);

        result = LongestValidParentheses.longestValidParenthesesOpt(str);
        System.out.println(result);
    }
}
