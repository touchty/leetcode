package string;

import dp.LongestIncreasingSubsequence;
import org.junit.Assert;

/*
925. Long Pressed Name
Easy

186

22

Favorite

Share
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            else if (j>= 1 && typed.charAt(j) == typed.charAt(j-1)) {
                j++;
            }
            else{
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        String[] names = {"alex", "saeed"};
        String[] typeds = {"aaleex", "ssaaedd"};
        boolean[] real = new boolean[names.length];
        boolean[] expected = {true, false};
        LongPressedName solution = new LongPressedName();
        for (int i = 0; i < names.length; i++) {
            real[i] = solution.isLongPressedName(names[i], typeds[i]);
        }
        Assert.assertArrayEquals(expected, real);
    }
}
