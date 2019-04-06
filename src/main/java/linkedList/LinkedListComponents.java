package linkedList;

import java.util.*;

/*
817. Linked List Components
Medium

200

474

Favorite

Share
We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input:
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation:
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input:
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation:
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:
If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Arrays.sort(G);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        ListNode curr = head;
        ListNode nextNode = head.next;
        int len = 1;
        if (nextNode == null) {
            Set<Integer> set = new HashSet<>();
            set.add(curr.val);
            map.put(curr.val, set);
        }
        while (nextNode != null) {
            if (map.containsKey(curr.val))
                map.get(curr.val).add(nextNode.val);
            else {
                Set<Integer> set = new HashSet<>();
                set.add(nextNode.val);
                map.put(curr.val, set);
            }

            if (map.containsKey(nextNode.val))
                map.get(nextNode.val).add(curr.val);
            else {
                Set<Integer> set = new HashSet<>();
                set.add(curr.val);
                map.put(nextNode.val, set);
            }
            curr = nextNode;
            nextNode = nextNode.next;
            len++;
        }

        boolean[] visited = new boolean[len];
        //Arrays.sort(G);
        int components = 0;
        for (int i : G) {
            if (!visited[i]) {
                components++;
                dfs(i, visited, G, map);
            }
        }

        return components;
    }

    void dfs(int node, boolean[] visited, int[] G, Map<Integer, Set<Integer>> map) {
        if (visited[node]) return;
        visited[node] = true;
        for (int next : map.get(node)) {
            if (Arrays.binarySearch(G, next) >= 0) {
                dfs(next, visited, G, map);
            }
        }
    }

    public int numComponentsOpt(ListNode head, int[] G) {
        Set<Integer> setG = new HashSet<>();
        for (int i : G) setG.add(i);
        int res = 0;
        while (head != null) {
            if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        /*ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        int[] G = {1,0};*/

        ListNode root = new ListNode(0);
        int[] G = {0};
        LinkedListComponents solution = new LinkedListComponents();
        int com = solution.numComponents(root, G);
        System.out.println(com);
    }
}
