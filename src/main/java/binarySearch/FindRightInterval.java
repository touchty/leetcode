package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public int[] findRightIntervalBi(Interval[] intervals) {
        int[] starts = new int[intervals.length];

        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indices.put(intervals[i].start, i);
            starts[i] = intervals[i].start;
        }

        Arrays.sort(starts);

        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int index = Arrays.binarySearch(starts, intervals[i].end);
            if (index >= 0) {
                result[i] = indices.get(starts[index]);
            } else {
                index = -index - 1;
                if (index < intervals.length)
                    result[i] = indices.get(starts[index]);
                else
                    result[i] = -1;
            }
        }

        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}