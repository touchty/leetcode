package string;

import org.junit.Assert;

/*
809. Expressive Words
Medium

88

266

Favorite

Share
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.

Given a list of query words, return the number of words that are stretchy.

Example:
Input:
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.

Notice:
"ddd", {"dd"} : answer is 1. Because the group of "dd" is "dd", and then we add one 'd' to this group, which becomes
"ddd" with a length >= 3!
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (check(S, word))
                count++;
        }
        return count;
    }

    public boolean check(String S, String W) {
        int n = S.length(), m = W.length(), i = 0, j = 0;
        for (int i2 = 0, j2 = 0; i < n && j < m; i = i2, j = j2) {
            if (S.charAt(i) != W.charAt(j)) return false;
            while (i2 < n && S.charAt(i2) == S.charAt(i)) i2++;
            while (j2 < m && W.charAt(j2) == W.charAt(j)) j2++;
            if (i2 - i != j2 - j && i2 - i < Math.max(3, j2 - j)) return false; // extended group
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        String S = "ddd";
        String[] words = {"dd"};
        ExpressiveWords expressiveWords = new ExpressiveWords();
        int res = expressiveWords.expressiveWords(S, words);
        int expected = 1;
        Assert.assertEquals(res, expected);
    }
}
