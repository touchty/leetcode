package stack;

import java.util.*;

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

    public static void main(String[] args) {
        String str  = "()";
        int result = LongestValidParentheses.longestValidParentheses(str);
        System.out.println(result);
    }
}
