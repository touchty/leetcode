package offer;

public class O48longestSubStringWithoutDuplication {
    // slid window
    public int longestSubStringWithoutDuplication(String str) {
        int[] cnts = new int[26];
        int longest = 0;
        for (int j = 0, i = 0; i < str.length(); i++) {
            cnts[str.charAt(i) - 'a']++;
            if (cnts[str.charAt(i) - 'a'] == 1) {
                longest = Math.max(longest, i - j + 1);
            } else {
                while (cnts[str.charAt(i) - 'a'] != 1) {
                    cnts[str.charAt(j) - 'a']--;
                    j++;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        O48longestSubStringWithoutDuplication solution = new
                O48longestSubStringWithoutDuplication();
        int longest = solution.longestSubStringWithoutDuplication(str);
        System.out.println(longest);
    }
}
