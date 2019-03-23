package graph;

public class LongestIncreasingPathInAMatrix {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] cached = new int[r][c];

        int max = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max = Math.max(max, dfs(matrix, i, j, r, c, cached));
            }
        }

        return max;
    }

    int dfs(int[][] matrix, int i, int j, int r, int c, int[][] cached) {
        if (cached[i][j] > 0) return cached[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int m = i + dir[0];
            int n = j + dir[1];
            if (m < 0 || m >= r || n < 0 || n >= c || matrix[m][n] <= matrix[i][j]) continue;
            max = Math.max(max, 1 + dfs(matrix, m, n, r, c, cached));

        }
        cached[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int res = new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix);
        System.out.println(res);
    }
}
