package HRQuestion.zhaoshangxyk;

import java.util.Scanner;

public class Q1 {
    static int[] count(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int i = 0;
        while (i < s.length()) {
            int index = s.indexOf("RL", i);
            if (index < 0)
                break;
            int sumR = 0;
            for (int j = index-1; j >= 0; j--) {
                if (s.charAt(j) == 'R') {
                    sumR++;
                }
                else break;
            }
            int sumL = 0;
            for (int j = index + 2; j < s.length(); j++) {
                if (s.charAt(j) == 'L') {
                    sumL++;
                } else
                    break;
            }
            dp[index] += (sumR / 2) + 1 + (sumL - (sumL / 2));
            dp[index + 1] += sumR - (sumR / 2) + 1 + (sumL / 2);
            i = index + 2;
        }
        return dp;
    }

    public static void main(String[] args) {
        /*String s = "RRLRL";
        int[] count = count(s);
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }*/
        /*String s = "RRRL";
        System.out.println(s.indexOf("RL", 4));*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] count = count(scanner.next());
            StringBuilder builder = new StringBuilder();
            for (int i : count) {
                builder.append(i).append(" ");
            }
            System.out.println(builder.toString());
        }

    }
}
