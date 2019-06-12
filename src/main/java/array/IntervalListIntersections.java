package array;

import java.util.ArrayList;
import java.util.List;

// LC 986. Interval List Intersections
// 求区间的交集
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end) {
                list.add(new int[]{start, end});
            }

            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        int[][] res = new int[list.size()][2];

        for (int k = 0; k < list.size(); k++) {
            int[] t = list.get(k);
            res[k][0] = t[0];
            res[k][1] = t[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
        IntervalListIntersections solution = new IntervalListIntersections();
        int[][] res = solution.intervalIntersection(A, B);
        System.out.println(res.length);
    }
}
