package dp;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        /*boolean isSubsequence = false;
        if (s == null || s.length() == 0)
            return true;*/

        int[] dp = new int[s.length()];

        int currPos = -1;

        for (int i = 0; i < s.length(); i++) {
            currPos = t.indexOf(s.charAt(i), currPos + 1);
            if (currPos < 0)
                return false;
        }

        return true;
    }
}
