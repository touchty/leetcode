package test;

import java.util.HashMap;
import java.util.Scanner;

public class LC1027 {
    public static int fooo(int[] A) {

        int result = 2, n = A.length;
        HashMap<Integer, Integer>[] myDp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            myDp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int diff = A[j] - A[i];
                myDp[j].put(diff, myDp[i].getOrDefault(diff, 1) + 1);
                result = Math.max(result, myDp[j].get(diff));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            System.out.println(fooo(A));
        }
    }
}
