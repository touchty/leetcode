package test;

import java.util.Stack;

public class BasicCalculatorIII {
    public int eval(String n) {

        int ans = 0, x = 0, y = 0;
        char d;
        // 逆波兰表达式
        Stack<Character> cal = new Stack<Character>();
        Stack<Integer> num = new Stack<Integer>();
        int i = 0;
        while (i < n.length()) {
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
                cal.pop(); // delete '('
            } else if (n.charAt(i) == '(') {
                cal.push('(');
            } else if (n.charAt(i) == '+' || n.charAt(i) == '-') {
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
            } else if (n.charAt(i) == '*' || n.charAt(i) == '/') {
                cal.push(n.charAt(i));
            } else if (n.charAt(i) >= '0' && n.charAt(i) <= '9') {
                int t = 0;
                while (i < n.length() && n.charAt(i) >= '0' && n.charAt(i) <= '9') {
                    t = t * 10 + (int) (n.charAt(i++) - 48);
                }
                num.push(t);
                continue;
            } else {
                // System.out.println("ERROR");
                return -1;
            }
            i++;
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
        String s = "10+(2+3)*15";
        BasicCalculatorIII solution = new BasicCalculatorIII();
        int res = solution.eval(s);
        System.out.println(res);
    }
}