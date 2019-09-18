package HRQuestion.meituan2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    boolean error = false;

    boolean ans(String[] s) {
        error = false;
        Deque<String> stack = new LinkedList<>();
        for (String t : s) {
            if (stack.isEmpty()) {
                if (t.equals("true") || t.equals("false")) {
                    stack.push(t);
                } else {
                    error = true;
                    return false;
                }
            } else if (t.equals("true") || t.equals("false")) {
                if (stack.peek().equals("or")) {
                    stack.push(t);
                } else if (stack.peek().equals("and")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        error = true;
                        return false;
                    }
                    String prev = stack.pop();
                    if (!(prev.equals("true") || prev.equals("false"))) {
                        error = true;
                        return false;
                    }
                    if (t.equals("true") && prev.equals("true")) {
                        stack.push("true");
                    } else
                        stack.push("false");
                } else {
                    error = true;
                    return false;
                }
            } else {
                stack.push(t);
            }

        }

        int t = 0;
        if (stack.isEmpty()) {
            error = true;
            return false;
        }
        if (stack.size() % 2 == 0) {
            error = true;
            return false;
        }
        if (stack.size() == 1) {
            if (stack.peek().equals("true"))
                return true;
            if (stack.peek().equals("false"))
                return false;
            else {
                error = true;
                return false;
            }
        }
        int index = 0;
        while (stack.size() > 0) {
            String curr = stack.pop();
            if (index == 0) {
                if (curr.equals("true"))
                    t++;
                else if (curr.equals("false"))
                    ;
                else {
                    error = true;
                    return false;
                }
            } else if (index == 1) {
                if (!curr.equals("or")) {
                    error = true;
                    return false;
                }
            }
            index = 1 - index;
        }
        return t > 0;
    }

    public static void main(String[] args) {
        /*String[] s = {"true", "or", "false", "and", "false"};
        Main q1 = new Main();
        boolean res = q1.ans(s);
        if (q1.error)
            System.out.println("error");
        else
            System.out.println(res);*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            Main q1 = new Main();
            boolean res = q1.ans(s);
            if (q1.error)
                System.out.println("error");
            else
                System.out.println(res);
        }
    }
}