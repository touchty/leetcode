package HRQuestion.wangyi3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1 {

    static String next(int x) {
        if (x < 10)
            return String.valueOf(x);
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        while (x >= 10) {
            x -= 9;
            stack.add(9);
        }
        builder.append(x);
        while (stack.size() > 0) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            System.out.println(next(x));
        }
    }

}
