package dp;

import java.util.HashMap;
import java.util.Map;

/*
691. Stickers to Spell Word
Hard

221

22

Favorite

Share
We are given N different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given target string by cutting individual letters from your collection of stickers and
rearranging them.

You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:

Input:

["with", "example", "science"], "thehat"
Output:

3
Explanation:

We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input:

["notice", "possible"], "basicbasic"
Output:

-1
Explanation:

We can't form the target "basicbasic" from cutting letters from the given stickers.
 */

public class StickerstoSpellWord {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (char c : stickers[i].toCharArray()) mp[i][c - 'a']++;
        dp.put("", 0);
        int min = helper(dp, mp, target);
        return min;
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE, n = mp.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) tar[c - 'a']++;
        // try every sticker
        for (int i = 0; i < n; i++) {
            // optimization
            if (mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            // apply a sticker on every character a-z
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0)
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++)
                        sb.append((char) ('a' + j));
            }
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) ans = Math.min(ans, 1 + tmp);
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }


    public int minStickersOpt(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (char c : stickers[i].toCharArray()) mp[i][c - 'a']++;
        dp.put("", 0);
        int min = helperOpt(dp, mp, target);
        return min;
    }
    private int helperOpt(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE;
        int n = mp.length;

        int[] tar = new int[26];
        for (char c : target.toCharArray()) tar[c - 'a']++;

        // try every sticker
        for (int i = 0; i < n; i++) {
            // optimization
            // if sticker does not contains target.charAt(0), does not use it!
            if (mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < tar.length; j++) {
                if (tar[j] > 0) {
                    // remaining chars after using sticker i
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++) {
                        builder.append((char) ('a' + j));
                    }
                }
            }
            String remainingStr = builder.toString();
            int temp = helperOpt(dp, mp, remainingStr);
            if (temp != -1) ans = Math.min(ans, 1 + temp); // current sticker and the stickers needed for remainingStr
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }

    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        // String word = "thehat";
        String word = "wg";
        StickerstoSpellWord solution = new StickerstoSpellWord();
        int minStickers = solution.minStickersOpt(stickers, word);
        System.out.println(minStickers);
    }
}
