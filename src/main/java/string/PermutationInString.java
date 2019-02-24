package string;

/*
567. Permutation in String
Medium

546

31

Favorite

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
 */

/*
Solution:
https://leetcode.com/problems/permutation-in-string/discuss/102590/8-lines-slide-window-solution-in-Java
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for (int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] == 1) // invalid substring
                /* slide the window, make sure the substring of s2 from l to r fill the s1*/
                while (--count[s2.charAt(l++)] != 0) {
                    // slide left point
                }
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }

    public static void main(String[] args) {
        String s1 = "idba", s2 = "eidbaooo";
        boolean res = PermutationInString.checkInclusion(s1, s2);
        System.out.println(res);
    }
}
