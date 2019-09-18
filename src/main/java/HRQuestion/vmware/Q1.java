package HRQuestion.vmware;

import java.util.Scanner;

public class Q1 {
    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static long kP(int n, int k) {
        if (n == 1)
            return k - 1;

        long start = 1;
        for (int i = 0; i < n - 1; i++) {
            start *= 10;
        }
        int index = 0;
        for (long i = start; i < start * 10; i++) {
            String s = String.valueOf(i);
            if (isPalindrome(s, 0, s.length() - 1)) {
                index++;
                if (index == k)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*int n1 = 1;
        int k1 = 5;
        System.out.println(kP(n1, k1));*/

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                res[index] = kP(n, k);
                index++;
            }
            for (long l: res)
                System.out.println(l);
        }
    }
}
