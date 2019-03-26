package array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Long, List<int[]>> map = new TreeMap<>();
        for (int[] point : points) {
            long d = point[0] * point[0] + point[1] * point[1];
            if (map.containsKey(d)) {
                map.get(d).add(point);
            } else {
                List<int[]> tList = new ArrayList<>();
                tList.add(point);
                map.put(d, tList);
            }
        }
        Map.Entry<Long, List<int[]>> e = null;
        List<int[]> list = new ArrayList<>();

        /*while (map.size() > 0) {
            e = map.pollFirstEntry();
            for (int[] point : e.getValue()) {
                list.add(point);
                if (list.size() == K) break;
            }
            if (list.size() == K) break;
        }*/
        for (Long d: map.navigableKeySet()) {
            if (list.size() == K) break;
            for (int[] point : map.get(d)) {
                list.add(point);
                if (list.size() == K) break;
            }
        }
        int[][] result = new int[K][2];
        return list.toArray(result);
    }

    public int[][] kClosestOpt(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]*b[0] + b[1]*b[1]
        - a[0]*a[0] - a[1]*a[1]));

        for (int[] point: points) {
            pq.offer(point);
            if(pq.size() > K) pq.poll();
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3}, {-2, 2}};
        int K = 1;
        KClosestPointstoOrigin solution = new KClosestPointstoOrigin();
        int[][] result = solution.kClosestOpt(points, K);
        int[][] expected = {{-2,2}};
        Assert.assertArrayEquals(expected, result);
    }
}
