package HRQuestion.wangyileihuo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1 {
    static void sort(Integer[][] matrix) {
        Arrays.sort(matrix, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] * o1[1] - o2[0] * o2[1] != 0)
                    return o1[0] * o1[1] - o2[0] * o2[1];

                double wh1 = (double) o1[0] / (double) o1[1];
                double hw1 = (double) o1[1] / (double) o1[0];
                double v1 = Math.min(wh1, hw1);

                double wh2 = (double) o2[0] / (double) o2[1];
                double hw2 = (double) o2[1] / (double) o2[0];
                double v2 = Math.min(wh2, hw2);

                /*
                int wh1 = o1[0] / o1[1];
                int hw1 = o1[1] / o1[0];
                int v1 = Math.min(wh1, hw1);

                int wh2 = o2[0] / o2[1];
                int hw2 = o2[1] / o2[0];
                int v2 = Math.min(wh2, hw2);
                 */
                if (Math.abs(v1 - v2) >= 0.000000000001) {
                    return v1 - v2 < 0 ? 1 : -1;
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
    }

    public static void main(String[] args) {
        /*Integer[][] matrix = {{2, 2}, {1, 1}};
        sort(matrix);
        System.out.println(matrix[0][0] + " " + matrix[0][1]);*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            Integer[][] matrix = new Integer[N][2];
            for (int i = 0; i < N; i++) {
                matrix[i][0] = scanner.nextInt();
                matrix[i][1] = scanner.nextInt();
            }
            sort(matrix);
            StringBuilder builder = new StringBuilder();
            for (Integer[] s : matrix) {
                builder.append(s[0]).append(" ").append(s[1]).append(" ");
            }
            System.out.println(builder.toString());
        }
    }
}
