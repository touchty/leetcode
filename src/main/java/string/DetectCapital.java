package string;

import org.junit.Assert;

/*
520. Detect Capital
Easy

288

173

Favorite

Share
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
 */
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return true;
        boolean isFirstUp = Character.isUpperCase(word.charAt(0));
        int countUp = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)))
                countUp++;
        }
        if (countUp == word.length() || (isFirstUp && countUp == 1) || countUp == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String[] testcases = {"USA", "flaG", "flag", "Google"};
        boolean[] expected = {true, false, true, true};
        boolean[] real = new boolean[testcases.length];
        for (int i = 0; i < testcases.length; i++) {
            real[i] = DetectCapital.detectCapitalUse(testcases[i]);
        }
        Assert.assertArrayEquals(expected, real);
    }
}
