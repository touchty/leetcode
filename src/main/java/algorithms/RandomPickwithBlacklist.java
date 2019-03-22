package algorithms;

import java.util.*;

/*
710. Random Pick with Blacklist
Hard

131

33

Favorite

Share
Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.

Optimize it such that it minimizes the call to system’s Math.random().

Note:

1 <= N <= 1000000000
0 <= B.length < min(100000, N)
[0, N) does NOT include N. See interval notation.
Example 1:

Input:
["Solution","pick","pick","pick"]
[[1,[]],[],[],[]]
Output: [null,0,0,0]
Example 2:

Input:
["Solution","pick","pick","pick"]
[[2,[]],[],[],[]]
Output: [null,1,1,1]
Example 3:

Input:
["Solution","pick","pick","pick"]
[[3,[1]],[],[],[]]
Output: [null,0,0,2]
Example 4:

Input:
["Solution","pick","pick","pick"]
[[4,[2]],[],[],[]]
Output: [null,1,3,1]
 */
public class RandomPickwithBlacklist {
    Map<Integer, Integer> map;
    Set<Integer> blackSet;
    Random random;
    int range;

    public RandomPickwithBlacklist(int N, int[] blacklist) {
        // B black num, N total, N-B valid
        // map black num [0,N-B] to valid num  [N-B,N]
        // [0,N-B)[N-B,N)
        this.blackSet = new HashSet<>();
        this.map = new HashMap<>();
        this.random = new Random();
        int B = blacklist.length;
        // save black num after N-B
        for (int num : blacklist) {
            if (num >= N - B)
                blackSet.add(num);
        }
        int val = N - B;
        // map black num before N-B
        for (int num : blacklist) {
            if (num < N - B) {
                while (blackSet.contains(val))
                    val++;
                map.put(num, val++);// notice ++
            }
        }
        this.range = N - B;
    }

    public int pick() {
        int key = this.random.nextInt(range);
        // if contains in black map, return val
        // otherwise valid, return directly
        return map.getOrDefault(key, key);
    }
}
