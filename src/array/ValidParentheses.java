package array;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        char[] Parentheses = {'(', ')', '{', '}', '[', ']'};
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < Parentheses.length / 2; i++) {
            map.put(Parentheses[2 * i], Parentheses[2 * i + 1]);
            map.put(Parentheses[2 * i + 1], Parentheses[2 * i]);
        }
        char[] str = s.toCharArray();
        for (char c : str) {
            if (!stack.isEmpty() && c == map.get(stack.getLast())) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidOpt(String s) {
        if (s.length() == 0) return true;
        char[] res = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case ('('):
                case ('{'):
                case ('['):
                    res[head] = c;
                    head++;
                    break;
                case (')'):
                    if (head == 0 || res[--head] != '(')
                        return false;
                    break;
                case ('}'):
                    if (head == 0 || res[--head] != '{')
                        return false;
                    break;
                case (']'):
                    if (head == 0 || res[--head] != '[')
                        return false;
                    break;

            }
        }
        return head == 0;
    }
}
