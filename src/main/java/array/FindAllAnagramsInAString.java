package array;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        int[] pArray = new int[26];
        int[] pArrayWindow = new int[26];
        List<Integer> list = new ArrayList<>();
        // TO-DO
        char[] pChars = p.toCharArray();
        char[] sChars = s.toCharArray();

        int window = p.length();

        for (int i = 0; i < pChars.length; i++) {
            pArray[pChars[i] - 'a']++;
        }
        for (int i = 0; i < p.length() && i < s.length(); i++) {
            pArrayWindow[sChars[i] - 'a']++;
        }

        for (int i = 0; i < s.length() - window + 1; i++) {
            if (i > 0)
                pArrayWindow[sChars[i - 1] - 'a']--;
            if (Arrays.equals(pArray, pArrayWindow)) list.add(i);
            if (i < s.length() - window)
                pArrayWindow[sChars[i + window] - 'a']++;

        }

        return list;
    }
    public List<Integer> findAnagramsOpt(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> list = FindAllAnagramsInAString.findAnagrams(s, p);

        for (int i : list)
            System.out.println(i);

        s = "abab";
        p = "ab";
        list = FindAllAnagramsInAString.findAnagrams(s, p);
        for (int i : list)
            System.out.println(i);
    }
}
// Runtime: 27 ms