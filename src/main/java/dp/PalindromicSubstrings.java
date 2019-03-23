package dp;

public class PalindromicSubstrings {
    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            extendLen(s, i, i);
            extendLen(s, i, i + 1);
        }
        return count;
    }

    void extendLen(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            } else
                break;
        }
    }
}
