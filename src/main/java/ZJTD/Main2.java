package ZJTD;

public class Main2 {
    static int mod = 1000000007;

    static long roads(int p) {
        long[] dp = new long[p + 1];
        dp[0] = 1;
        dp[2] = 1;
        if (p <= 2)
            return dp[p];
        for (int i = 4; i <= p; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                // 避免溢出
                dp[i] += (long) dp[i - j] * dp[j - 2] % mod;
            }
        }
        return dp[p];
    }

    public static void main(String[] args) {
        int p = 4;
        int res = (int) roads(p);
        System.out.println(res);

        /*Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();

            int cs = roads(m);
            System.out.println(cs);
        }*/
    }
}
