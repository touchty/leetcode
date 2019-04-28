package array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        int[] temp = new int[]{intervals[0][0], intervals[0][1]};
        for (int[] interval : intervals) {
            if (interval[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], interval[1]);
            } else {
                int[] merged = new int[]{temp[0], temp[1]};
                list.add(merged);
                temp = new int[]{interval[0], interval[1]};
            }
        }
        list.add(temp);

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals s = new MergeIntervals();
        int[][] res = s.merge(ints);
        System.out.println(res.length);
    }
}
