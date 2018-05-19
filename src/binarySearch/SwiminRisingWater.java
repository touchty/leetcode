package binarySearch;

import java.util.PriorityQueue;

public class SwiminRisingWater {
    public int swimInWater(int[][] g) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] v= new int[g.length][g[0].length];

        pq.offer(new int[]{g[0][0], 0, 0});
        v[0][0] = 1;

        int res = 0;

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(tmp[1] == g.length-1 && tmp[2] == g[0].length-1) {
                res = tmp[0];
                break;
            }
            for(int[] dir: dirs) {
                int next_r = tmp[1]+dir[0];
                int next_c = tmp[2]+dir[1];

                if(next_r>=0 && next_r < g.length && next_c >=0 && next_c < g[0].length && v[next_r][next_c] == 0) {
                    if(g[next_r][next_c] < tmp[0]) {
                        g[next_r][next_c] = tmp[0];
                    }
                    pq.offer(new int[]{g[next_r][next_c], next_r, next_c});
                    v[next_r][next_c] = 1;
                }
            }
        }

        return res;
    }
}
