package stack;

import java.util.*;

public class MaximumFrequencyStack {
    HashMap<Integer, Integer> freq = new HashMap<>(); // <element : frequency>
    HashMap<Integer, Stack<Integer>> m = new HashMap<>(); // <frequency: elements with the same frequence>
    int maxfreq = 0;
    int size = 0;
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxfreq = Math.max(maxfreq, f);
        if (!m.containsKey(f)) m.put(f, new Stack<Integer>());
        m.get(f).add(x);
        size++;
    }

    public int pop() {
        if(size == 0) return -1;
        size--;
        int x = m.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);
        if (m.get(maxfreq).size() == 0) maxfreq--;
        return x;
    }

    public static void main(String[] strs) {
        int[] nums = {5,5,5,6,7};
        MaximumFrequencyStack solution = new MaximumFrequencyStack();
        for (int i : nums) {
            solution.push(i);
        }

        for (int i = 0; i < nums.length+2; i++) {
            int j = solution.pop();
            System.out.println(j);
        }
    }
}