package array;

public class MinimumWindowsSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];

        for (char c : t.toCharArray()) map[c]++;

        int count = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;  //in t
            while (count == 0) {  // valid
                if (end - begin < d) {
                    d = end - begin;
                    head = begin;
                }
                if (map[s.charAt(begin++)]++ == 0)  //make it invalid.
                    count++;  // s.charAt(begin) is in target
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
        String s = "XAABC";
        String t = "ABC";

        MinimumWindowsSubstring minimumWindowsSubstring = new MinimumWindowsSubstring();
        String result = minimumWindowsSubstring.minWindow(s, t);
        System.out.println(result);
    }

}
