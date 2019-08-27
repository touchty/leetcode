package test;

import java.util.Stack;

public class BasicCalculatorIII {
    public int eval(String n) {

        int ans = 0, x = 0, y = 0;
        char d;
        Stack<Character> cal = new Stack<Character>();
        Stack<Integer> num = new Stack<Integer>();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == ')') {
                while (cal.peek() != '(') {
                    d = cal.pop();
                    x = num.pop();
                    y = num.pop();
                    if (d == '+') {
                        num.push(x + y);
                    }
                    if (d == '-') {
                        num.push(y - x);
                    }
                    if (d == '*') {
                        num.push(x * y);
                    }
                    if (d == '/') {
                        num.push(y / x);
                    }
                }
                cal.pop();
                continue;
            }
            if (n.charAt(i) == '(') {
                cal.push('(');
                continue;
            }
            if (n.charAt(i) == '+' || n.charAt(i) == '-') {
                while (!cal.empty() && cal.peek() != '(') {
                    d = cal.pop();
                    x = num.pop();
                    y = num.pop();
                    if (d == '+') {
                        num.push(x + y);
                    }
                    if (d == '-') {
                        num.push(y - x);
                    }
                    if (d == '*') {
                        num.push(x * y);
                    }
                    if (d == '/') {
                        num.push(y / x);
                    }
                }
                cal.push(n.charAt(i));
                continue;
            } else if (n.charAt(i) == '*' || n.charAt(i) == '/') {
                cal.push(n.charAt(i));
                continue;
            } else if (n.charAt(i) >= '0' && n.charAt(i) <= '9') {
                num.push((int) (n.charAt(i) - 48));
                continue;
            } else {
                // System.out.println("ERROR");
                return -1;
            }
        }
        while (!cal.empty()) {
            d = cal.pop();
            x = num.pop();
            y = num.pop();
            if (d == '+') {
                num.push(x + y);
            }
            if (d == '-') {
                num.push(y - x);
            }
            if (d == '*') {
                num.push(x * y);
            }
            if (d == '/') {
                num.push(y / x);
            }
        }
        ans = num.pop();

        return ans;
    }

    public static void main(String[] args) {
        String s = "1+2+3*4";
        s = "0" + s;
        BasicCalculatorIII solution = new BasicCalculatorIII();
        int res = solution.eval(s);
        System.out.println(res);
    }
}