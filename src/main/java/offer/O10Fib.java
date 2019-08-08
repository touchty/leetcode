package offer;

import java.util.Arrays;

public class O10Fib {
    // 10.1斐波那契数列
    public int Fibonacci(int n) {
        if (n <= 1) return n;

        int pre1 = 1;
        int pre2 = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }

        return fib;
    }

    // 10.2 矩形覆盖
    // f(1) = 1;
    // f(2) = 2;
    // f(n) = f(n-1) + f(n-2)
    public int RectCover(int n) {
        if (n <= 2) return n;
        int pre1 = 2;
        int pre2 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    // 10.3 跳台阶
    //NowCoder
    //
    //题目描述
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int res = 0;
        int pre1 = 2;
        int pre2 = 1;
        for (int i = 3; i <= n; i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    // 10.4 变态跳台阶
    //NowCoder
    //
    //题目描述
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
    // 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }
}
