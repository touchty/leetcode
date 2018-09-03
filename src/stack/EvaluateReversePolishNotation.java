package stack;

import java.util.LinkedList;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
//        String[] strs = {"2","1","+","3","*"};
        String[] strs = {"2","1","+", "3","*"};

        EvaluateReversePolishNotation e  = new EvaluateReversePolishNotation();

        int res = e.evalRPN(strs);

        System.out.println(res);
    }
}
