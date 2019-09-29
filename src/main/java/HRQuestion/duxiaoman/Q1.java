package HRQuestion.duxiaoman;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }
        long mycount = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            int k = i + 1;
            if (2 * k > n - 1) {
                mycount += list[2 * k - 1];
                list[i] = Math.max(0, list[i] - list[2 * k - 1]);
            } else {
                mycount += Math.max(list[2 * k - 1], list[2 * k]);
                list[i] = Math.max(0, list[i] - Math.max(list[2 * k - 1], list[2 * k]));
            }
        }
        if (list[0] != 0)
            mycount += list[0];
        System.out.println(mycount);
    }
}
