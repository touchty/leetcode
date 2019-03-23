package array;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/*
Greedy polynomial solution
The following greedy algorithm does find the optimal solution:

Select the interval, x, with the earliest finishing time.
Remove x, and all intervals intersecting x, from the set of candidate intervals.
Repeat until the set of candidate intervals is empty.
Whenever we select an interval at step 1, we may have to remove many intervals in step 2. However, all these intervals
necessarily cross the finishing time of x, and thus they all cross each other (see figure). Hence, at most 1 of these intervals can be in the optimal solution. Hence, for every interval in the optimal solution, there is an interval in the greedy solution. This proves that the greedy algorithm indeed finds an optimal solution.

A more formal explanation is given by a Charging argument.

The greedy algorithm can be executed in time O(n log n), where n is the number of tasks, using a preprocessing step in which the tasks are sorted by their finishing times.
 */

/*
435. Non-overlapping Intervals
Medium

407

16

Favorite

Share
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingIntervals {
    public static class Interval {
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

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

    public static void main(String[] args) {
        int[][] intervalsArr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Interval[] intervals = new Interval[intervalsArr.length];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = new Interval(intervalsArr[i][0], intervalsArr[i][1]);
        }
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int res = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        int expected = 1;
        Assert.assertEquals(expected, res);
    }

}
