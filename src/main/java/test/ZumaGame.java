package test;

public class ZumaGame {
    int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        int total = hand.length();
        for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
        /*int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
        return rs == MAXCOUNT ? -1 : rs;*/

        int[] res = {Integer.MAX_VALUE};
        helper(board, handCount, res, total);
        if (res[0] == Integer.MAX_VALUE)
            return -1;
        return res[0];
    }

    /*private int helper(String s, int[] h) {
        s = removeConsecutive(s);
        if (s.equals("#")) return 0;
        int rs = MAXCOUNT, need = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == s.charAt(i)) continue;
            need = 3 - (j - i);     //balls need to remove current consecutive balls.
            if (h[s.charAt(i) - 'A'] >= need) {
                h[s.charAt(i) - 'A'] -= need;
                rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
                h[s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return rs;
    }*/
    private int helper(String s, int[] h, int[] res, int total) {
        s = removeConsecutive(s);
        if (s == null || s.length() == 0) {
            char[] rgb = {'R', 'Y', 'B', 'G', 'W'};
            int cnt = 0;
            for (char c : rgb) {
                if (h[c - 'A'] > 0) {
                    cnt += h[c - 'A'];
                }
            }
            res[0] = Math.min(res[0], total - cnt);
            return 0;
        }
        char[] rgb = {'R', 'Y', 'B', 'G', 'W'};
        int cnt = 0;
        for (char c : rgb) {
            if (h[c - 'A'] == 0) {
                cnt++;
            }
        }
        if (cnt == 5)
            return -1;

        int step = -1;
        for (char c : rgb) {
            if (h[c - 'A'] > 0) {
                h[c - 'A']--;
                for (int i = 0; i <= s.length(); i++) {
                    String newStr = new StringBuilder().append(s.substring(0, i)).append(c).append(s.substring(i)).toString();
                    int n = helper(newStr, h, res, total);
                    if (n == -1) continue;
                    if (step == -1) step = n + 1;
                    else step = Math.min(step, n + 1);
                }
                h[c - 'A']++;
            }
        }
        return step;
    }

    //remove consecutive balls longer than 3
    String removeConsecutive(String board) {
        if (board == null || board == "")
            return board;
        for (int i = 0, j = 0; j <= board.length(); ++j) {
            if (j == board.length()) {
                if (j - i >= 3)
                    return board.substring(0, i);
                else return board;
            }
            if (board.charAt(j) == board.charAt(i)) continue;
            if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        return board;
    }

    public static void main(String[] args) {
        String board = "RRWWRRBBRR";
        String hand = "WB";
        ZumaGame solution = new ZumaGame();
        int inserts = solution.findMinStep( "WRRBBW", "RB");
        String s1 = solution.removeConsecutive("RRWWRRBBRWR");
        String s2 = solution.removeConsecutive("RRWWRRBBBRWR");
        String s3 = solution.removeConsecutive("RRR");
        String s4 = solution.removeConsecutive("RRWWRRRR");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(inserts);
    }

}
