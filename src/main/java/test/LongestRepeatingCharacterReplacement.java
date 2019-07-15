package test;

// 424. Longest Repeating Character Replacement
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxIdentical = 0;
        int maxReplaced = 0;
        int ALPHA = 26;
        int[] count = new int[ALPHA];
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            maxIdentical = Math.max(maxIdentical, count[s.charAt(i) - 'A']);
            if (i - j + 1 - maxIdentical <= k)
                maxReplaced = Math.max(maxReplaced, i - j + 1);
            else
                count[s.charAt(j++) - 'A']--; // 向右滑动
        }
        return maxReplaced;
    }

    public static void main(String[] args) {
        /*String s = "ABAB";
        int k = 2;
        int maxRelaced = LongestRepeatingCharacterReplacement.characterReplacement(s, k);
        System.out.println(maxRelaced);*/

        String s1 = "AABABBA";
        int k1 = 0;
        int maxRelaced1 = LongestRepeatingCharacterReplacement.characterReplacement(s1, k1);
        System.out.println(maxRelaced1);

    }
}
