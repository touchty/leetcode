package dp;

/**
 * 514. Freedom Trail
 * Hard
 *
 * In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.
 *
 * Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.
 *
 * Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button.
 *
 * At the stage of rotating the ring to spell the key character key[i]:
 *
 * You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
 * If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.
 * Example:
 *
 *
 *
 * Input: ring = "godding", key = "gd"
 * Output: 4
 * Explanation:
 * For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
 * For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 * Also, we need 1 more step for spelling.
 * So the final output is 4.
 */
public class FreedomTrail {
    public static int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        int[][] dp = new int[m + 1][n];
        //Start by solving key[i:m-1] -> smallest instance is key[m-1:m-1]
        for (int i = m - 1; i >= 0; i--) {
            //Solve the problem for key[i:m-1] and when the ring arrow points at index j.
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //Try out every type of spin (by 0, 1, 2, 3, and choose the best choice)
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        //Using greedy logic that we should just use the min spin
                        int diff = Math.abs(j - k);
                        //Choose the min of moving clockwise or counterclockwise
                        int step = Math.min(diff, n - diff);
                        //dp[i+1][k] = Solve the subproblem from key[i+1: m-1] and while our pointer points to k now since
                        //we have rotated the dial there.
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m; //We will press the dial button m times in total no matter what.
    }

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        int steps = findRotateSteps(ring, key);
        System.out.println(steps);
    }
}
