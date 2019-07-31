package test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 拓扑排序，找到入度为0的点作为起点
        // 之后采用栈进行深度优先
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new LinkedList<>());
        }
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]); // edge
        }

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                stack.push(i); // store the start point
        }
        int n = numCourses;

        while (stack.size() > 0) {
            int start = stack.pop();
            n--;
            for (int next : adj.get(start)) {
                if (--inDegree[next] == 0) {
                    stack.push(next);
                }
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] pres = {{1, 0}};
        boolean res = CourseSchedule.canFinish(n, pres);
        System.out.println(res);
    }
}
