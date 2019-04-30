package test;

import java.util.ArrayList;
import java.util.List;

//合并区间
// 测试用例包括[[]], [1,2]
// [1,2],[3,4]
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        merge(0, intervals, newInterval, list);
        return list.toArray(new int[list.size()][2]);
    }

    void merge(int i, int[][] intervals, int[] newInterval, List<int[]> list) {
        if (i >= intervals.length) {
            list.add(newInterval);
            return;
        }
        int[] t = intervals[i];
        if (newInterval[0] > t[1]) {
            list.add(t);
            merge(i + 1, intervals, newInterval, list);
            return;
        } else if (newInterval[1] < t[0]) {
            list.add(newInterval);
            for (; i < intervals.length; i++)
                list.add(intervals[i]);
            return;
        } else {
            int start = Math.min(t[0], newInterval[0]);
            int end = Math.max(t[1], newInterval[1]);
            merge(i + 1, intervals, new int[]{start, end}, list);
        }

    }

    public int[][] insertOptIterative(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] t : intervals) {
            if (newInterval[0] > newInterval[1] || newInterval[0] > t[1])
                list.add(t);
            else if (newInterval[1] < t[0]) {
                list.add(newInterval);
                list.add(t);
                newInterval = new int[]{2, 1}; // invalid
            } else {
                newInterval[0] = Math.min(newInterval[0], t[0]);
                newInterval[1] = Math.max(newInterval[1], t[1]);
            }
        }
        if (newInterval[0] <= newInterval[1])
            list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
