package test;

import java.util.*;

// LC 895. Maximum Frequency Stack
// 最大频率栈

public class MaximumFrequencyStack {
    /*Map<Integer, Set<Integer>> map;
    List<Deque<Integer>> list;
    int maxFreq = 0;

    public MaximumFrequencyStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
        maxFreq = 0;
    }

    public void push(int x) {
        if (maxFreq == 0) {
            maxFreq = 1;
            Set<Integer> set = new HashSet<>();
            set.add(x);
            map.put(maxFreq, set);
            Deque<Integer> stack = new LinkedList<>();
            stack.push(x);
            list.add(stack);
        } else {
            int nextFreq = 1;
            for (int i = 1; i <= maxFreq; i++) {
                if (map.get(i).contains(x)) nextFreq = i + 1;
            }
            if (nextFreq == maxFreq + 1) {
                Set<Integer> set = new HashSet<>();
                set.add(x);
                map.put(nextFreq, set);

                Deque<Integer> stack = new LinkedList<>();
                stack.push(x);
                list.add(nextFreq - 1, stack);
                maxFreq = nextFreq;
            } else {
                map.get(nextFreq).add(x);
                list.get(nextFreq - 1).push(x);
            }
        }
    }

    public int pop() {
        if (maxFreq <= 0)
            return -1;

        int val = list.get(maxFreq - 1).pop();
        if (list.get(maxFreq - 1).size() == 0) {
            list.remove(maxFreq - 1);
            map.remove(maxFreq);
            maxFreq--;
        } else {
            map.get(maxFreq).remove(val);
        }
        return val;
    }*/


    // optimization 90%
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> m = new HashMap<>();
    int maxfreq = 0;

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxfreq = Math.max(maxfreq, f);
        if (!m.containsKey(f)) m.put(f, new Stack<Integer>());
        m.get(f).add(x);
    }

    public int pop() {
        int x = m.get(maxfreq).pop();
        freq.put(x, maxfreq - 1);
        if (m.get(maxfreq).size() == 0) maxfreq--;
        return x;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack maxStack = new MaximumFrequencyStack();
        int[] nums = {5, 7, 5, 7, 4, 5};
        for (int n : nums)
            maxStack.push(n);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(maxStack.pop());
        }
    }
}
