package HRQuestion.dianxinyun;

import java.util.Scanner;

public class Q1 {
    static int unique(int[] A) {
        int res = 0;
        for (int a : A) {
            res = res ^ a;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
                int res = unique(A);
                System.out.println(res);
            }
        }
    }
}
