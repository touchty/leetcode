package test;

// poj 2411 Mondriaan's Dream(状态压缩dp)
// https://blog.csdn.net/u014634338/article/details/50015825

public class Poj2411MondriaansDream {
    long[][] dp;
    int n, m;

    boolean init(int status) {
        for (int j = 0; j < m; ) //前j-1列符合要求，对第j列进行判断
        {
            if ((status & (1 << j)) != 0) //第j列为1
            {
                if (j == m - 1) //j为最后一列，不可行
                    return false;
                if ((status & (1 << (j + 1))) != 0) //第j列和第j+1列都为1 则表示横放，可行，考虑 j+2列
                    j += 2;
                else //第j列为1，第j+1列都为0不可行
                    return false;
            } else //第j列为0 ，则为竖放，可行
                j++;
        }
        return true;
    }

    //判断上一次状态和本次状态是否兼容
    boolean check(int now_s, int pre_s) {
        for (int j = 0; j < m; ) {
            if ((now_s & (1 << j)) != 0) //第i行第j列为1
            {
                if ((pre_s & (1 << j)) != 0) //第i-1行第j列也为1，那么第i行必然是横放
                {
                    //第i行和第i-1行的第j+1都必须是1，否则是非法的
                    if (j == m - 1 || (now_s & 1 << (j + 1)) == 0 || (pre_s & 1 << (j + 1)) == 0)
                        return false;
                    else
                        j += 2;
                } else
                    j++; //第i-1行第j列为0，说明第i行第j列是竖放
            } else  //第i行第j列为0，那么第i-1行的第j列应该是已经填充了的
            {
                if ((pre_s & (1 << j)) != 0)
                    j++;
                else
                    return false;
            }
        }
        return true;
    }

    long solve(int n, int m) {
        this.n = n;
        this.m = m;
        dp = new long[n + 1][1 << m];
        int tot = (1 << m) - 1;
        for (int s = 0; s <= tot; s++) {
            if (init(s))
                dp[1][s] = 1;
        }

        for (int i = 2; i <= n; i++) //按行dp
        {
            for (int j = 0; j <= tot; j++) //第i行的状态
            {
                for (int k = 0; k <= tot; k++) //第i-1行的状态
                {
                    if (check(j, k))
                        dp[i][j] += dp[i - 1][k];
                }
            }
        }
        return dp[n][tot];
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        Poj2411MondriaansDream solution = new Poj2411MondriaansDream();
        solution.solve(n, m);
    }
}
