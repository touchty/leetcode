package HRQuestion.pdd;

// 骰子期望
public class O_2_3 {
    public static double exp(int[] xis) {
        int maxXi = 0;
        for (int i : xis)
            maxXi = Math.max(maxXi, i);
        long[] dp = new long[maxXi + 1];
        dp[1] = 1;
        for (int i = 2; i <= maxXi; i++) {
            long p = 1;
            long q = 1;
            for (int j = 0; j < xis.length; j++) {
                if (xis[j] < i) {
                    p *= xis[j];
                    q *= xis[j];
                } else {
                    p *= i;
                    q *= (i - 1);
                }
            }
            dp[i] = p - q;
        }
        long sum = 0;
        for (int i = 1; i <= maxXi; i++) {
            sum += i * dp[i];
        }
        long total = 0;
        for (int j = 1; j <= maxXi; j++) {
            total += dp[j];
        }
        double exp = (double) sum / total;
        return exp;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] xis = {3, 2};
        double avg = exp(xis);
        System.out.println(avg);
    }
}