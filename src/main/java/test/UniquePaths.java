package test;

// 数学题
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }
        long a = 1;
        long b = 1;
        for(int i = 0; i < m-1; i++)
            a *= (m+n-2 - i);

        for(int i = m-1; i >= 2; i--) {
            b *= i;
        }

        return (int) (a/b);
    }

    public static void main(String[] args) {
        int m = 36;
        int n = 7;
        int res = UniquePaths.uniquePaths(m,n);
        System.out.println(res);
    }
}
