package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
方法2：深度优先遍历
算法流程（思路是通过 DFS 判断图中是否有环）：
借助一个标志列表 flags，用于判断每个节点 i （课程）的状态：
未被 DFS 访问：i == 0；
已被其他节点启动的DFS访问：i == -1；
已被当前节点启动的DFS访问：i == 1。
对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 FalseFalse。DFS 流程；
终止条件：
当 flag[i] == -1，说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 TrueTrue。
当 flag[i] == 1，说明在本轮 DFS 搜索中节点 i 被第 22 次访问，即 课程安排图有环，直接返回 FalseFalse。
将当前访问节点 i 对应 flag[i] 置 11，即标记其被本轮 DFS 访问过；
递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 FalseFalse；
当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 -1−1 并返回 TrueTrue。
若整个图 DFS 结束并未发现环，返回 TrueTrue。
复杂度分析：
时间复杂度 O(N + M)O(N+M)：遍历一个图需要访问所有节点和所有临边，NN 和 MM 分别为节点数量和临边数量；
空间复杂度 O(N)O(N)，为建立邻接矩阵所需额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LC207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false; // on stack
        if (flags[i] == -1) return true; // visited by previous dfs
        flags[i] = 1;
        for (int j = 0; j < adjacency.length; j++) {
            if (adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            List<Integer> list = map.getOrDefault(cp[1], new LinkedList<>());
            list.add(cp[0]);
            map.put(cp[1], list);
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            // 入度为0
            if (indegrees[i] == 0) queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            /*for (int[] req : prerequisites) {
                if (req[1] != pre) continue;
                if (--indegrees[req[0]] == 0) queue.add(req[0]);
            }*/
            if (!map.containsKey(pre))
                continue;
            for (int next : map.get(pre)) {
                if (--indegrees[next] == 0)
                    queue.add(next);
            }
        }
        return numCourses == 0;
    }

    boolean hasCycle = false;
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        boolean hasCycle = false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] cp : prerequisites) {
            List<Integer> list = map.getOrDefault(cp[1], new LinkedList<>());
            list.add(cp[0]);
            map.put(cp[1], list);
        }
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) DFS(v, map, marked, onStack);
        }
        return !hasCycle;
    }

    private void DFS(int v, Map<Integer, List<Integer>> map, boolean[] marked,
                     boolean[] onStack) {
        marked[v] = true;
        onStack[v] = true;
        if (hasCycle)
            return;

        if (map.containsKey(v)) {
            for (int next : map.get(v)) {
                if (!marked[next])
                    DFS(next, map, marked, onStack);
                else if (onStack[next]) {
                    hasCycle = true;
                    return;
                }
            }
        }
        onStack[v] = false;
    }

    public static void main(String[] args) {
        int[][] prerequists = {{1, 0}, {0, 1}};
        LC207CourseSchedule s = new LC207CourseSchedule();
        boolean res = s.canFinishDFS(2, prerequists);
        System.out.println(res);
    }
}
