package HRQuestion.zhaoshangxyk;

import java.util.Scanner;

public class Q11 {
    static int[] mycount(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int i = 0;
        while (i < s.length()) {
            int myindex = s.indexOf("RL", i);
            if (myindex < 0)
                break;
            int mysumR = 0;
            int mysumL = 0;
            for (int j = myindex + 2; j < s.length(); j++) {
                if (s.charAt(j) == 'L') {
                    mysumL++;
                } else
                    break;
            }
            for (int j = myindex - 1; j >= 0; j--) {
                if (s.charAt(j) == 'R') {
                    mysumR++;
                } else break;
            }
            dp[myindex] += (mysumR / 2) + 1 + (mysumL - (mysumL / 2));
            dp[myindex + 1] += mysumR - (mysumR / 2) + 1 + (mysumL / 2);
            i = myindex + 2;
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        while (myscanner.hasNext()) {
            StringBuilder builder = new StringBuilder();
            int[] mycount = mycount(myscanner.next());
            for (int i : mycount) {
                builder.append(i).append(" ");
            }
            System.out.println(builder.toString());
        }

    }
}
