package test;

import java.util.*;

public class FrequencyOutput {
    String frequencyOutput(String str, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int total = 0;
        for (char c : str.toCharArray()) {
            total++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> (a.getValue() - b.getValue()));
        int[] count = new int[entries.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> e : entries) {
            if (i == 0)
                count[i] = e.getValue() - 1;
            else
                count[i] = count[i - 1] + e.getValue();
            i++;
        }

        StringBuilder builder = new StringBuilder(n);
        Random random = new Random();
        for (int j = 0; j < n; j++) {
            int r = random.nextInt(total);
            int index = Arrays.binarySearch(count, r);
            index = index >= 0 ? index : -index - 1;
            builder.append(entries.get(index).getKey());
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String str = "AABC";
        int n = 10000;
        FrequencyOutput solution = new FrequencyOutput();
        String randomOutput = solution.frequencyOutput(str, n);
        System.out.println(randomOutput);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : randomOutput.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + (double) entry.getValue() / n);
        }
    }

}
