package HRQuestion.xiaomi;

import java.util.Scanner;

public class Q_qimiao2 {
    static int end(int sum) {
        if (sum <= 0)
            return -1;
        int can = (int) (Math.sqrt(2 * sum + 0.25) - 0.5);

        int can1 = can - 1;
        int can2 = can + 1;

        if (can * (can + 1) == 2 * sum)
            return can;
        if (can1 * (can1 + 1) == 2 * sum)
            return can1;
        if (can2 * (can2 + 1) == 2 * sum)
            return can2;
        return -1;
    }

    public static void main(String[] args) {
        /*int sum = 1111;
        int end = end(sum);
        System.out.println(end);*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int sum1 = scanner.nextInt();
            int end1 = end(sum1);
            if (end1 == -1)
                System.out.println("No");
            else
                System.out.println(end1);
        }
    }
}
