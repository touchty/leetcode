package HRQuestion.vmware;

import java.util.Scanner;

public class Q1 {
    public static boolean isPalindrome(String s, int di, int gao) {
        while (di < gao)
            if (s.charAt(di++) != s.charAt(gao--)) return false;
        return true;
    }

    public static long kP(int n, int iNum) {
        if (n == 1)
            return iNum - 1;
        int i;
        int HD;
        int Mh;
        int Md;
        int result;

        Mh = 1;
        Md = n;
        HD = (Md + 1) / 2;


        for (i = 2; i <= HD; i++) {
            Mh *= 10;
        }
        Mh += iNum - 1;

        result = Mh;
        if ((Md & 1) != 0) {
            Mh /= 10;
        }

        while (Mh != 0) {
            result = result * 10 + Mh % 10;
            Mh /= 10;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sss = new Scanner(System.in);
        int idx = 0;
        while (sss.hasNextInt()) {
            int N = sss.nextInt();
            long[] result = new long[N];
            for (int i = 0; i < N; i++) {
                int n = sss.nextInt();
                int k = sss.nextInt();
                result[idx] = kP(n, k);
                idx++;
            }
            for (long l : result)
                System.out.println(l);
        }
    }
}
