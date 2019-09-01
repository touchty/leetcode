package pq;

import java.util.*;

public class MaxInterchangeOfIntervals {
    int maxInterchange(int[][] intervals) {
        return 0;
    }

    public static List<Integer> distinct(List<int[]> intervals) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] interval : intervals) {
            set.add(interval[0]);
            set.add(interval[1]);
        }
        return new ArrayList<>(set);
    }

    public static int maxInterval(List<int[]> intervals) {
        // 提取所有x
        List<Integer> pos = distinct(intervals);
        List<Integer> count = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparingInt((x) -> x[0]));
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < pos.size() - 1; i++) {
            while (index < intervals.size() &&
                    intervals.get(index)[0] == pos.get(i)) {
                // 右端点进堆
                Q.add(intervals.get(index)[1]);
                index++;
            }
            // 堆里面的数量就是当前线段的数量
            count.add(Q.size());
            // 堆里面的元素出列,当前点pos.get(i)到达时间间隔终点-Q.peek()，代表线段终止，走出Q.peek()覆盖区域
            // 所以出栈
            while (!Q.isEmpty() && Q.peek() == pos.get(i).intValue()) {
                Q.poll();
            }
        }
        // 枚举所有x, 最后一个不用算了，肯定是0
        return count.stream().max(Comparator.comparingInt((x) -> x)).get();
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1, 3}, {5, 9}, {6, 8}, {7, 9}};
        int[][] intervals = {{5, 9}, {6, 7}};
        int max = maxInterval(Arrays.asList(intervals));
        System.out.println(max);
    }
}