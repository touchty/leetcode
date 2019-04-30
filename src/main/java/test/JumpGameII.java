package test;

import java.util.Deque;
import java.util.LinkedList;

/*

BFS
 */
public class JumpGameII {
    public int jump(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 1;
        int maxRange = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                maxRange = Math.max(maxRange, currIdx);
                if (currIdx == nums.length - 1)
                    return step - 1;
                int range = currIdx + nums[currIdx];
                for (int next = range; next > maxRange; next--) {
                    if (next < nums.length) {
                        if (next == nums.length - 1) return step;
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    /*
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int step = 0;
        int maxRange = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currIdx = queue.poll();
                maxRange = Math.max(maxRange, currIdx);
                if (currIdx == nums.length - 1)
                    return step;
                int range = currIdx + nums[currIdx];
                for (int next = range; next >  maxRange; next--) {
                    if (next >= nums.length - 1) return step + 1;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }

            }
            step++;
        }
        return step;
    }
     */

    int jumpOpt(int A[]) {
        int n = A.length;
        if (n < 2) return 0;
        int level = 0, currentMax = 0, i = 0, nextMax = 0;

        // i ---- |currentMax :current layer
        while (currentMax - i + 1 > 0) {        //nodes count of current level>0
            level++;
            for (; i <= currentMax; i++) {    //traverse current level , and update the max reach of next level
                nextMax = Math.max(nextMax, A[i] + i);
                if (nextMax >= n - 1) return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax = nextMax;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] jump = {1,0,0,1};
        JumpGameII s = new JumpGameII();
        int res = s.jumpOpt(jump);
        System.out.println(res);
    }
}
