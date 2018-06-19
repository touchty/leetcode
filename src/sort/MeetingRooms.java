package sort;

import java.util.Arrays;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return true;
        intervals.sort((Interval l1, Interval l2) -> (l1.start - l2.start));

        int end = Integer.MIN_VALUE;

        for (Interval interval : intervals) {
            if (interval.start < end)
                return false;
            end = Math.max(end, interval.end);
        }
        return true;
    }
}
