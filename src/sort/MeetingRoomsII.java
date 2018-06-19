package sort;

import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int room = 0;
        int max = 0;
        for (int num : map.values()) {
            room += num;
            // parallel
            max = Math.max(max, room);
        }
        return max;
    }
}
