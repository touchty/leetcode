package HRQuestion.dianxinyun;

import java.util.Scanner;

public class Q5 {
    static int myxor(int[] A, int[] B) {
        int x = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                x ^= (A[i] + B[j]);
            }
        }
        return x;
    }

    static int myxorOpt(int[] A, int[] B) {
        int x = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                x ^= (A[i] + B[j]);
            }
        }
        return x;
    }

    public static void main(String[] args) {
        /*int n = 5;
        int[] A = {1, 2, 1, 0, 0};
        int[] B = {1, 2, 3, 0, 0};
        int res = myxor(A, B);
        System.out.println(res);*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = scanner.nextInt();
            }
            int res = myxor(A, B);
            System.out.println(res);
        }
    }
}
