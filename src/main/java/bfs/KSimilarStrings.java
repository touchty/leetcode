package bfs;

import org.junit.Assert;

import java.util.*;

/*
854. K-Similar Strings
Hard

138

16

Favorite

Share
Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1
Example 2:

Input: A = "abc", B = "bca"
Output: 2
Example 3:

Input: A = "abac", B = "baca"
Output: 2
Example 4:

Input: A = "aabc", B = "abca"
Output: 2
 */

// bfs
public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        int[] count = new int[26];
        for (char c : A.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : B.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return -1;
        }
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(A);
        vis.add(A);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            for (int sz = q.size(); sz > 0; sz--) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i)) i++;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j)) continue;
                    String temp = swap(s, i, j);
                    if (temp.equals(B)) return res;
                    if (vis.add(temp)) q.add(temp);
                }
            }
        }
        return res;
    }

    public String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }

    public static void main(String[] args) {
        String A = "abc", B = "bca";
        KSimilarStrings solution = new KSimilarStrings();
        int minSwaps = solution.kSimilarity(A, B);
        int expected = 2;
        Assert.assertEquals(expected, minSwaps);
        System.out.println(minSwaps);
    }
}