package HRQuestion.wangyileihuo;

import java.util.Scanner;

public class Q4 {
    static int[] nums = new int[1000000 + 1];
    static double[] res = new double[nums.length];

    static {
        eulerNew(nums);
        FminHelper(nums.length - 1);
    }

    static int euler(int n) {
        int res = n;
        int a = n;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                res = res / i * (i - 1);
                while (a % i == 0)
                    a /= i;
            }
        }
        if (a > 1) res = res / a * (a - 1);
        return res;
    }

    static int eulerOpt(int n) {
        if (1 <= n && n < nums.length)
            return nums[n];
        else return euler(n);
    }

    static void eulerNew(int[] A) {
        A[1] = 1;

        for (int i = 2; i < A.length; i++) {
            if (A[i] == 0) {
                for (int j = i; j < A.length; j += i) {
                    if (A[j] == 0)
                        A[j] = j;
                    A[j] = A[j] / i * (i - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*int N = 6;
        double res = Fmin(N);
        System.out.println(String.format("%.6f", res));*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            double res = Fmin(N);
            System.out.println(String.format("%.6f", res));
        }
    }

    static double Fmin(int N) {
        if (1 <= N && N <= nums.length - 1)
            return res[N];
        double min = Double.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            double t = (double) eulerOpt(i) / (double) i;
            min = Math.min(min, t);
        }
        return min;
    }

    static void FminHelper(int N) {
        double min = Double.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            double t = (double) eulerOpt(i) / (double) i;
            min = Math.min(min, t);
            res[i] = min;
        }
    }
}
