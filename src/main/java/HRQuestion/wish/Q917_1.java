package HRQuestion.wish;

public class Q917_1 {
    static int[] index(int[][] matrix, int t) {
        int[] res = {-1, -1};
        if (matrix == null || matrix.length == 0)
            return res;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == t) {
                res[0] = i;
                res[1] = j;
                return res;
            } else if (matrix[i][j] > t) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 20, 300}, {4, 50, 600}, {7, 80, 900}};
        int t = 50;
        int[] res = index(matrix, t);
        System.out.println(res[0] + " : " + res[1]); // {1, 1}
    }
}
