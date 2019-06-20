package test;


/*
Essentially, we have to multiply the existed ugly numbers by 2, 3 and 5 to get a bigger ugly number, however, if we
blindly multiply all the existed numbers by 2, 3 and 5, then the number could grow much faster than needed
Hence, every time we only try to find the next smallest ugly number
Also, since any existed number will be multiplied by 2, 3 and 5 once and only once, otherwise duplicate, we can use a
pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step.
Once, we find the next minimum, we can move on the corresponding pointer, otherwise it always stays at the already
existed ugly number which would makes pointer useless
 */
public class UglyNumberII {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            // Also, since any existed number will be multiplied by 2, 3 and 5 once and only once,
            // otherwise duplicate, we can use a
            // pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step.
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }
}
