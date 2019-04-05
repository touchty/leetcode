package array;

import org.junit.Assert;

public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int pos = - S.length();

        // distance to the previous left C
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = i - pos;
        }
        pos = 2 * S.length();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C)
                pos = i;
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        ShortestDistancetoaCharacter solution = new ShortestDistancetoaCharacter();
        int[] dists = solution.shortestToChar(S, C);
        int[] expected = {3,2,1,0,1,0,0,1,2,2,1,0};
        Assert.assertArrayEquals(expected, dists);
    }
}
