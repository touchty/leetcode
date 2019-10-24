package HRQuestion;

import java.util.Scanner;

public class Main {
    static boolean isP(long n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        for (long i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    boolean isPVal(int n) {
        long i = n * n + n + 41;
        return isP(i);
    }

    static boolean[] ps = new boolean[90];

    public Main() {
        for (int i = 0; i < 90; i++) {
            ps[i] = isPVal(i - 39);
        }
    }

    public static void main(String[] args) {
        Main myMain = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x == 0 && y == 0)
                return;
            for (int i = x + 39; i <= y + 39; i++) {
                if (!ps[i])
                    System.out.println("Sorry");
            }
            System.out.println("OK");
        }
        /*int x = 0;
        int y = 2;
        for (int i = x+39; i <= y+39; i++) {
            if (!ps[i])
                System.out.println("Sorry");
        }
        System.out.println("OK");*/
    }
}