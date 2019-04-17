package array;

public class MatrixPath {
    public boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows == 0 || cols == 0 || str == null)
            return false;
        boolean[][] v = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean res = dfs(matrix, i, j, str, 0, v);
                if (res)
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] matrix, int i, int j, char[] str, int pos, boolean[][] v) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 ||
                v[i][j] || str[pos] != matrix[i][j])
            return false;
        if (pos == str.length - 1)
            return true;
        v[i][j] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (dfs(matrix, x, y, str, pos + 1, v))
                return true;
        }
        v[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
        MatrixPath s = new MatrixPath();
        char[] path = {'a', 'b', 'c', 'f', 'h'};
        boolean res = s.hasPath(matrix, 3, 3, path);
        System.out.println(res);
    }
}
