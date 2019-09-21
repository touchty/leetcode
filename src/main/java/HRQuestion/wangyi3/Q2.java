package HRQuestion.wangyi3;

import java.util.Scanner;

public class Q2 {
    static int actions(int A, int B, int p, int q) {
        int diff = B - A;
        int count = 0;
        long t = p;
        while (t < diff) {
            t *= q;
            count++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        /*int A = 1;
        int B = 15;
        int p = 4;
        int q = 2;
        int counts = actions(A, B, p, q);
        System.out.println(counts);*/

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int counts = actions(A, B, p, q);
            System.out.println(counts);
        }
    }
}
