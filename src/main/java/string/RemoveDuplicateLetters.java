package string;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/*
316. Remove Duplicate Letters
Hard
599
69
Favorite
Share
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and
only once. You must make sure your result is the smallest in lexicographical order among all possible results.
Example 1:
Input: "bcabc"
Output: "abc"
Example 2:
Input: "cbacdcbc"
Output: "acdb"
 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static String removeDuplicateLettersOpt(String str) {
        int[] count = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = str.toCharArray();
        for (char c : ch) {  //count number of occurences of character
            count[c - 'a']++;
        }
        Deque<Character> st = new LinkedList<>(); // answer stack
        int index;
        for (char s : ch) {
            index = s - 'a';
            count[index]--;   //decrement number of characters remaining in the string to be analysed
            if (visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!st.isEmpty() && s < st.peek() && count[st.peek() - 'a'] > 0) {
                visited[st.pop() - 'a'] = false;
            }
            st.push(s); //add current character and mark it as visited
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "bcabc";
        String res = RemoveDuplicateLetters.removeDuplicateLettersOpt(str);
        String expected = "abc";
        Assert.assertEquals(expected, res);

        str = "cbacdcbc";
        res = RemoveDuplicateLetters.removeDuplicateLettersOpt(str);
        expected = "acdb";
        Assert.assertEquals(expected, res);
    }
}
