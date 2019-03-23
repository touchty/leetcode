package pq;

import java.util.*;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        pq.addAll(map.entrySet());
        list.addAll(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                sb.append(e.getKey());
        }
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < (int) entry.getValue(); i++)
                sb2.append(entry.getKey());
        }
        return sb.toString();
        // return sb2.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        String res = SortCharactersByFrequency.frequencySort(str);
        System.out.println(res);
    }

}
