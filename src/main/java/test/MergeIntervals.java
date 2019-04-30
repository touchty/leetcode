package test;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> list = new ArrayList<>();

        int s = intervals[0][0];
        int e = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= e)
                e = Math.max(e, interval[1]);
            else {
                list.add(new int[]{s, e});
                s = interval[0];
                e = interval[1];
            }
        }
        list.add(new int[]{s, e});
        //int[][] res = new int[list.size()][2];
        int[][] res = list.toArray(new int[list.size()][]);
        /*for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }*/
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] res = MergeIntervals.merge(intervals);
        for (int[] i : res) {
            System.out.println(i[0] + "::" + i[1]);
        }

        ArrayList<int[]> foo = new ArrayList<>();
        foo.add(new int[]{1,2});
        foo.add(new int[]{3,4});
        int[][] bar = foo.toArray(new int[foo.size()][]);
        System.out.println(bar[0][0] + "::" + bar[0][1]);
        foo.get(0)[0] = 10086;
        foo.get(0)[1] = 10087;
        System.out.println(bar[0][0] + "::" + bar[0][1]);

        foo.get(0)[0] = 1234;
        foo.get(0)[1] = 5687;
        System.out.println(bar[0][0] + "::" + bar[0][1]);

        ArrayList<int[]> testList = (ArrayList<int[]>) foo.clone();
        System.out.println(testList.get(0)[0]);


        foo.get(0)[0] = 321;
        foo.get(0)[1] = 654;
        System.out.println(bar[0][0] + "::" + bar[0][1]);

        System.out.println(testList.get(0)[0]);
    }
}
