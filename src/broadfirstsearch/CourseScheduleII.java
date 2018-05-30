package broadfirstsearch;

import java.util.ArrayList;
import java.util.List;


/*
* This problem is a classic graph topological sort problem. Each prerequisite has edges to the courses that require it.

We define in degree as the number of edges into a node in the graph. What we do is we remove the nodes that has in
degree equals to 0, decrease the in degree of the nodes that require the current node, and repeat, until we've removed
all the nodes (the successful case), or there's no node with in degree equals to 0 (the failed case).

So, we can do this using a priority queue, and make the in degree as the priority. Every time we poll a node from the
queue, and decrease the priorities of the children of the node. If the polled node has in degree larger than 1, it means
we failed. But since Java's priority queue doesn't support convenient decrease key operation, we have to remove one
node and add it back, which causes bad performance.

Or we can use two pointers. We put the removed node in an array, and use a left pointer to iterate through the array
and decrease the in degrees of the nodes than require the current node. And use a right pointer to add those nodes which
have 0 in degree after the decreasing operation. Repeat this until all nodes are added.
* */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDeg = new int[numCourses];
        List<Integer>[] chl = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            chl[i] = new ArrayList<Integer>();
        }

        int pre;
        int cour;

        for (int[] pair : prerequisites) {
            pre = pair[1];
            cour = pair[0];

            // PRE -> COUR
            chl[pre].add(cour);
            inDeg[cour]++;
        }

        int[] res = new int[numCourses];
        int k = 0;

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                res[k++] = i;
            }
        }
        // No valid start course
        if (k == 0) {
            return new int[0];
        }

        int j = 0;
        List<Integer> tmp;

        while (k < numCourses) {
            tmp = chl[res[j++]];

            for (int id : tmp) {
                if (--inDeg[id] == 0) {
                    res[k++] = id;
                }
            }

            // When there exists no "--inDeg[id] == 0" case and k stop growing. Ultimately, j will catch up with k.
            if (j == k) {
                return new int[0];
            }
        }

        return res;
    }
}
