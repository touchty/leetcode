package offer;

public class O4SearchMAtrix {
    public static boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col]) {
                col--;
            } else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 16;
        boolean find = O4SearchMAtrix.Find(target, matrix);
        System.out.println(find);

        int target1 = 25;
        boolean find1 = O4SearchMAtrix.Find(target1, matrix);
        System.out.println(find1);
    }
}
