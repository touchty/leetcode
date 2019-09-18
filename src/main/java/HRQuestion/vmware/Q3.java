package HRQuestion.vmware;

import java.util.Scanner;

public class Q3 {
    static int count(int a, int b, int k) {
        int c = 0;
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                if (k - 1 < 2)
                    c++;
                else {
                    boolean v = true;
                    for (int j = 2; j <= k - 1; j++) {
                        if (i % j == 0) {
                            v = false;
                            break;
                        }
                    }
                    if (v)
                        c++;
                }

            }
        }
        return c;
    }

    public static void main(String[] args) {
        /*int a = 12;
        int b = 23;
        int k = 3;
        int res = count(a, b, k);
        System.out.println(res);*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            int res = count(a, b, k);
            System.out.println(res);
        }
    }
}
