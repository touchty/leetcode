package HRQuestion.tencent;

import java.util.Scanner;

public class Q1 {
    public static boolean can(String s) {
        if (s == null || s.length() < 11)
            return false;
        int index = s.indexOf("8");
        if (index < 0)
            return false;
        int count = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                count++;
        }
        return count == 11;
    }

    public static void main(String[] args) {
        /*String[] strings = {"88888888888", "000"};
        for (String s : strings) {
            boolean res = can(s);
            if (res)
                System.out.println("YES");
            else
                System.out.println("NO");
        }*/

        Scanner in = new Scanner(System.in);

        int N = Integer.valueOf(in.nextLine());
        for (int i = 0; i < N; i++) {
            String len = in.nextLine();
            String s = in.nextLine();
            boolean res = can(s);
            if (res)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
