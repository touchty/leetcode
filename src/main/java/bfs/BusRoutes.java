package bfs;

import java.util.*;

public class BusRoutes {
    /*
    For each of the bus stop, we maintain all the buses (bus routes) that go through it. To do that, we use a HashMap, where bus stop number is the key and all the buses (bus routes) that go through it are added to an ArrayList.
    We use BFS, where we process elements in a level-wise manner. We add the Start bus stop in the queue. Next, when we enter the while loop, we add all the bus stops that are reachable by all the bus routes that go via the Start. Thus, if we have the input as [[1, 2, 7], [3, 6, 7]] and Start as 6, then upon processing bus stop 6, we would add bus stops 3 and 7.
    With this approach, all the bus stops at a given level, are "equal distance" from the start node, in terms of number of buses that need to be changed.
    To avoid loops, we also maintain a HashSet that stores the buses that we have already visited.
    */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>();  // visited through S
        Queue<Integer> q = new LinkedList<>();

        // Set is better than List
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int ret = 0;

        if (S == T) return 0;

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                // check if we already have a list of stops following
                Set<Integer> buses = map.getOrDefault(routes[i][j], new HashSet<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            ret++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                Set<Integer> buses = map.get(cur);
                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
