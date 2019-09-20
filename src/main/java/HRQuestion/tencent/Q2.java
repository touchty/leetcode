package HRQuestion.tencent;

import java.util.Arrays;
import java.util.Comparator;

public class Q2 {
    public static int max(Integer[][] matrix) {
        Arrays.sort(matrix, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        int i = 0;
        int j = matrix.length - 1;
        int myMax = Integer.MIN_VALUE;
        while (i <= j) {
            if (i == j && matrix[i][1] == 0)
                break;
            while (i < matrix.length && matrix[i][1] <= 0)
                i++;
            while (j >= 0 && matrix[j][1] <= 0)
                j--;
            if (i > j)
                break;
            myMax = Math.max(myMax, matrix[i][0] + matrix[j][0]);
            int tcount = Math.min(matrix[i][1], matrix[j][1]);
            matrix[i][1] -= tcount;
            matrix[j][1] -= tcount;
        }
        return myMax;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{8, 1}, {5, 2}, {2, 1}};
        int res = max(matrix);
        System.out.println(res);

        /*Scanner in = new Scanner(System.in);

        int N = Integer.valueOf(in.nextLine());
        Integer[][] matrix = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            int count = in.nextInt();
            int delay = in.nextInt();
            matrix[i][0] = delay;
            matrix[i][1] += count;
        }
        int maxDelay = max(matrix);
        System.out.println(maxDelay);*/
    }
}
