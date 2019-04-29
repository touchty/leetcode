package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
227. Basic Calculator II
Medium

565

85

Favorite

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                // sign is the sign before the current number
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i); // next sign before any number 3 + 2 * 2 (sign is '+', '+', '*')
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

    public int calculateOpt(String s) {
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
                if (sign == '+')
                    stack.push(num);
                if (sign == '-')
                    stack.push(-num);
                if (sign == '*')
                    stack.push(stack.pop() * num);
                if (sign == '\\')
                    stack.push(stack.pop() / num);
                sign = s.charAt(i); // next sign
                num = 0; // clear num
            }
        }

        int res = 0;
        for (int i : stack)
            res += i;
        return res;
    }

    public static void main(String[] args) {
        String s = "3 + 2 * 2";
        BasicCalculatorII calculatorII = new BasicCalculatorII();
        int res = calculatorII.calculateOpt(s);
        System.out.println(res);
    }
}
