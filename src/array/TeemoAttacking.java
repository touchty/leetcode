package array;

/*
The same idea as https://leetcode.com/problems/merge-intervals/
Algorithm:

Use two variable to record current start and end point.
If the start of new interval is greater than current end, meaning NO overlapping, we can sum the current interval length to result and then update start and end.
Otherwise just update the current end;
*/
public class TeemoAttacking {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;

        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;

        return result;
    }
}
