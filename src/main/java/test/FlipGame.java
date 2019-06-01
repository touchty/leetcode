package test;

import java.util.ArrayList;
import java.util.List;

// LC 293 Flip Game
public class FlipGame {
    /**
     * @param s GIVEN INITIAL STRING
     * @return All possible states in after next move.
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> lists = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == '+') {
                chars[i - 1] = '-';
                chars[i] = '-';
                lists.add(new String(chars));
                chars[i - 1] = '+';
                chars[i] = '+';
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        FlipGame solution = new FlipGame();
        String s = "++++";
        String s1 = "---+++-+++-+";
        List<String> lists = solution.generatePossibleNextMoves(s);
        List<String> lists1 = solution.generatePossibleNextMoves(s1);
        System.out.println(lists.size());
        for (String l : lists)
            System.out.println(l);

        System.out.println(lists1.size());
        for (String l : lists1)
            System.out.println(l);
    }
}
