package HRQuestion.vmware;

import java.util.Scanner;

public class Q1 {
    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static long kP(int n, int iNum) {
        if (n == 1)
            return iNum - 1;
        int Halfdist, myHalf, myDegree, myd, res;
        int i;

        myd = 9;
        for (myDegree = 1; myDegree < n; myDegree++) {
            if (myDegree % 2 == 0) {
                myd *= 10;
            }
        }

        Halfdist = (myDegree + 1) / 2;

        myHalf = 1;
        for (i = 2; i <= Halfdist; i++) {
            myHalf *= 10;
        }
        myHalf += iNum - 1;

        res = myHalf;
        if ((myDegree & 1) != 0) {
            myHalf /= 10;
        }

        while (myHalf != 0) {
            res = res * 10 + myHalf % 10;
            myHalf /= 10;
        }

        return res;
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
            for (long l : res)
                System.out.println(l);
        }
    }
}
