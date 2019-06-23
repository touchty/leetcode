package sort;

import java.util.Arrays;

public class Sort2DMatrix {
    static int sortRowWise(int m[][]) {
        for (int[] a : m) {
            Arrays.sort(a);
        }
        return 0;
    }

    public static void main(String[] args) {
        int m[][] = {{9, 8, 7, 1},
                {7, 3, 0, 2},
                {9, 5, 3, 2},
                {6, 3, 1, 2}};
        sortRowWise(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println(m[i][j]);
            }
        }
    }
}
