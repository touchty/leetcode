package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 4);
        Interval i3 = new Interval(4, 6);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        List<Interval> res = new MergeIntervals().merge(list);
        for (Interval i : res)
            System.out.println(i.start + " -> " + i.end);
    }
}
