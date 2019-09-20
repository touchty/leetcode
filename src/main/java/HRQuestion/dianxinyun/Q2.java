package HRQuestion.dianxinyun;

import java.util.Scanner;

public class Q2 {
    public static boolean isSame(String s, String t) {
        int[] q = new int[256];
        int[] p = new int[256];
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            if (p[s.charAt(i)] != q[t.charAt(i)])
                return false;
            p[s.charAt(i)] = i + 1;
            q[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] strings = line.split(";");
            if (isSame(strings[0], strings[1]))
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
