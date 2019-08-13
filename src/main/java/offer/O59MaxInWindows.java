package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class O59MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>(num.length);
        if (size > num.length || size < 1)
            return list;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < size && i < num.length; i++) {
            pq.add(num[i]);
        }

        list.add(pq.peek());

        for (int i = size; i < num.length; i++) {
            pq.remove(num[i - size]);
            pq.add(num[i]);
            list.add(pq.peek());
        }
        return list;
    }
}
