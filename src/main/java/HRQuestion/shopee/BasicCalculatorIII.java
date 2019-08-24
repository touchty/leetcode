package HRQuestion.shopee;

import java.util.Stack;

public class BasicCalculatorIII {
    Stack<Long> numbers = new Stack<>();
    Stack<Character> ops = new Stack<>();
    public int error = 0;

    public BasicCalculatorIII() {
        Stack<Long> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        error = 0;
    }


    public int calculate(String s) {
        String num = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (!Character.isDigit(c) && c != '(' && c != ')' && c != '+'
                    && c != '-' && c != '*' && c != '/') {
                this.error = 1;
                return -1;
            }
            if (Character.isDigit(c)) {
                num = num + c;
                // If no next char, or next char is not digit, then this is the number
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    numbers.push(Long.parseLong(num));
                    num = "";
                }
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // Keep calculating until we see (
                while (ops.peek() != '(') {
                    char op = ops.peek();
                    long second = numbers.pop();
                    long first = numbers.pop();
                    operation(ops.pop(), first, second);
                }
                ops.pop();
            } else {
                if (!ops.empty() && !isHigherPriority(c, ops.peek()) && ops.peek() != '(') {
                    long second = numbers.pop();
                    long first = numbers.pop();
                    operation(ops.pop(), first, second);
                }

                ops.push(c);
            }
        }

        while (numbers.size() > 1) {
            long second = numbers.pop();
            long first = numbers.pop();
            operation(ops.pop(), first, second);
        }
        return numbers.pop().intValue();
    }

    public void operation(char op, long first, long second) {
        if (op == '+') numbers.push(first + second);
        if (op == '-') numbers.push(first - second);
        if (op == '*') numbers.push(first * second);
        if (op == '/') numbers.push(first / second);
    }

    public boolean isHigherPriority(char op1, char op2) {
        //if(op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "0-1-1+1";
        BasicCalculatorIII calculatorIII = new BasicCalculatorIII();
        int res = calculatorIII.calculate(s);
        System.out.println(res);
    }
}
