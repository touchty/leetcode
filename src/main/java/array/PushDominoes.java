package array;

/*
838. Push Dominoes
Medium

270

29

Favorite

Share
There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state.

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 */

/*
Intuition:
Whether be pushed or not, depend on the shortest distance to 'L' and 'R'.
Also the direction matters.
Base on this idea, you can do the same thing inspired by this problem.
https://leetcode.com/problems/shortest-distance-to-a-character/discuss/125788/

Here is another idea that focus on 'L' and 'R'.
'R......R' => 'RRRRRRRR'
'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
'L......R' => 'L......R'
'L......L' => 'LLLLLLLL'

Time Complexity:
O(N)
 */
public class PushDominoes {
    public String pushDominoes(String d) {
        d = 'L' + d + 'R';
        StringBuilder res = new StringBuilder();
        for (int i = 0, j = 1; j < d.length(); ++j) {
            if (d.charAt(j) == '.') continue;
            int middle = j - i - 1; // length of middle part
            if (i > 0) res.append(d.charAt(i));
            if (d.charAt(i) == d.charAt(j))
                for (int k = 0; k < middle; k++) res.append(d.charAt(i));
            else if (d.charAt(i) == 'L' && d.charAt(j) == 'R')
                // 'L......R' => 'L......R'
                for (int k = 0; k < middle; k++) res.append('.');
            else {
                // 'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
                for (int k = 0; k < middle / 2; k++) res.append('R');
                if (middle % 2 == 1) res.append('.');
                for (int k = 0; k < middle / 2; k++) res.append('L');
            }
            i = j;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String d = "L.R";
        PushDominoes dominoes = new PushDominoes();
        String result = dominoes.pushDominoes(d);
        System.out.println(result);
    }
}
