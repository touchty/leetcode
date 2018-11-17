package algorithms;

import org.junit.Assert;

import java.util.Arrays;

public class SuperPow {
    static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0)
            return 1;
        return helper(a, b, b.length - 1);
    }

    int helper(int a, int[] b, int end) {
        if (end < 0)
            return 1;
        return (powMod(helper(a, b, end - 1), 10) * powMod(a, b[end])) % MOD;
    }
    // (a ^ b) mod 1337;
    // 0 <= b <= 10
    static int powMod(int a, int b) {
        if (b == 0 || a == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 0; i < b; i++) {
            res = (res * a) % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 2};
        int[][] b = {{3}, {1,0}};
        int[] res = new int[a.length];
        int[] expected = {8, 1024};
        SuperPow superPow = new SuperPow();
        for (int i = 0; i < a.length; i++) {
            res[i] = superPow.superPow(a[i], b[i]);
        }
        Assert.assertArrayEquals(expected, res);
    }
}
