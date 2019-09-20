package HRQuestion.vmware;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    static int count(Integer[][] records) {
        Arrays.sort(records, (a, b) -> (a[1] - b[1]));
        int n = records.length;
        int aaa = 0;
        int bbb = 0;
        for (int i = 0; i < n; i++) {
            int a = n - i;
            aaa += records[i][0];
            bbb += records[i][1];
            if (aaa >= a)
                return bbb;
        }
        return 0;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            Integer[][] rs = new Integer[N][2];
            for (int i = 0; i < N; i++) {
                rs[i][0] = sc.nextInt();
                rs[i][1] = sc.nextInt();
                System.out.println(count(rs));
            }
        }*/

    }
}
