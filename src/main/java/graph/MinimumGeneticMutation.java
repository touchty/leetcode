package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
433. Minimum Genetic Mutation
Medium

231

32

Favorite

Share
A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.


Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1


Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2


Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
 */

/*
Solution:
Use BFS to find the minimum distance.
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        boolean[] visited = new boolean[bank.length];
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        //bfs
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                String node = queue.poll();
                if (node.equals(end))
                    return level - 1;
                for (int i = 0; i < bank.length; i++) {
                    if (!visited[i] && diffOne(node, bank[i])) {
                        queue.add(bank[i]);
                        visited[i] = true;
                    }
                }
            }
        }
        return -1;
    }

    boolean diffOne(String a, String b) {
        int i = 0;
        int diff = 0;
        for (; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        if (i < a.length()) {
            diff += a.length() - i;
        } else if (i < b.length()) {
            diff += b.length() - i;
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        /*
        "AAAAACCC"
        "AACCCCCC"
        ["AAAACCCC","AAACCCCC","AACCCCCC"] 3

        "AACCGGTT"
        "AACCGGTA"
        -1

        "AACCGGTT"
        "AAACGGTA"
        ["AACCGGTA","AACCGCTA","AAACGGTA"] 2
         */
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        int res = minimumGeneticMutation.minMutation(start, end, bank);
        System.out.println(res);
    }
}
