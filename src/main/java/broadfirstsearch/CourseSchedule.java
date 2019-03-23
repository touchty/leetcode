package broadfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 207. Course Schedule
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, int course) {

        if (visited[course])         // have circle
            return false;
        visited[course] = true;
        for (int i = 0; i < adj[course].size(); i++) {
            if (!dfs(adj, visited, adj[course].get(i)))
                return false;
            adj[course].remove(i);  // delete edge
        }
        visited[course] = false;
        return true;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        int[] indegree = new int[numCourses];
        Queue<Integer> readyCourses = new LinkedList();
        int finishCount = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);
            indegree[curCourse]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)  // no prerequisites
                readyCourses.offer(i);
        }
        while (!readyCourses.isEmpty()) {
            int course = readyCourses.poll();        // finish
            finishCount++;
            for (int nextCourse : adj[course]) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0)  // all its prerequisites are met
                    readyCourses.offer(nextCourse);  // ready
            }
        }
        return finishCount == numCourses;  // no circle detected!
    }
}
