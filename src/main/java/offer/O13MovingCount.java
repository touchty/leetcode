package offer;

// 13. 机器人的运动范围
//NowCoder
//
//题目描述
//地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
//
//例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
//
//解题思路
//使用深度优先搜索（Depth First Search，DFS）方法进行求解。回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。而普通的深度优先搜索并不需要使用这些局部状态，虽然还是有可能设置一些全局状态。
public class O13MovingCount {
    final static int[][] nexts = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int count = 0;

    public int movingCount(int threshold, int r, int c) {
        int[][] digitSum = buildDigitSum(r, c);
        dfs(0, 0, threshold, digitSum, new boolean[digitSum.length][digitSum[0].length]);
        return count;
    }

    int[][] buildDigitSum(int r, int c) {
        int[][] digitSum = new int[r][c];
        int[] digit = new int[Math.max(r, c)];
        for (int i = 0; i < digit.length; i++) {
            int n = i;
            while (n > 0) {
                digit[i] += n % 10;
                n /= 10;
            }
        }

        for (int i = 0; i < digitSum.length; i++) {
            for (int j = 0; j < digitSum[0].length; j++) {
                digitSum[i][j] = digit[i] + digit[j];
            }
        }
        return digitSum;
    }

    void dfs(int r, int c, int threshold, int[][] digitSum, boolean[][] visited) {
        if (r < 0 || r >= digitSum.length || c < 0 || c >= digitSum[0].length ||
                visited[r][c] || digitSum[r][c] > threshold)
            return;

        visited[r][c] = true;
        count++;
        for (int[] next : nexts) {
            dfs(r + next[0], c + next[1], threshold, digitSum, visited);
        }
    }

    public static void main(String[] args) {
        int r = 12;
        int c = 15;
        int threshold = 4;
        O13MovingCount solution = new O13MovingCount();
        int steps = solution.movingCount(threshold, r, c);
        System.out.println(steps);
    }
}
