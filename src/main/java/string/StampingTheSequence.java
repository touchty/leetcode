package string;

import java.util.ArrayList;

/**
 * 936. Stamping The Sequence
 * Hard
 * 57
 * 18
 * Favorite
 * Share
 * You want to form a target string of lowercase letters.
 * At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.
 * On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.
 * For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)
 * If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
 * For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.
 * Example 1:
 * Input: stamp = "abc", target = "ababc"
 * Output: [0,2]
 * ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 * Example 2:
 * Input: stamp = "abca", target = "aabcaca"
 * Output: [3,0,1]
 */

/*
Solution :
https://leetcode.com/problems/stamping-the-sequence/discuss/189258/C%2B%2B-Reverse-Operation-30-ms-better-than-DFS
What I basiclly did here is trying to reverse the whole operations.
The operation token later will be more apperant than the operation token before. The letters which stamped later will
cover the letters stamped before and we really don't care about the letters which are covered.
 */
public class StampingTheSequence {
    int cnt = 0;

    public int[] movesToStamp(String stamp, String target) {
        if (!target.contains(stamp)) return new int[0];
        ArrayList<Integer> rev = new ArrayList<>();
        char[] cStamp = stamp.toCharArray();
        char[] cTarget = target.toCharArray();
        while (cnt < cTarget.length) {
            int index = remove(cStamp, cTarget);
            if (index == -1) return new int[0];
            rev.add(index);
        }

        int[] ans = new int[rev.size()];
        int i = rev.size() - 1;
        for (int e : rev) {
            ans[i--] = e;
        }
        return ans;
    }

    public int remove(char[] cStamp, char[] cTarget) {
        int m = cStamp.length, n = cTarget.length;
        for (int begin = 0; begin <= n - m; ++begin) {
            boolean found = false;
            int i, j;
            for (i = begin, j = 0; j < m; ++i, ++j) {
                if (cTarget[i] != '*' && cTarget[i] != cStamp[j]) {
                    break;
                } else if (cTarget[i] == cStamp[j]) {
                    found = true;
                }
            }
            if (j == m && found) {
                for (int k = begin; k < begin + m; ++k) {
                    if (cTarget[k] != '*') {
                        cTarget[k] = '*';
                        ++cnt;
                    }
                }
                return begin;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String stamp = "abc";
        String target = "ababc";
        int[] res = new StampingTheSequence().movesToStamp(stamp, target);
        for (int pos : res) {
            System.out.println(pos);
        }
    }
}
