package string;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        final int len = words.length;
        int[] charSet = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            String temp = words[i];
            for (int j = 0; j < temp.length(); j++) {
                charSet[i] |= 1 << (temp.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int production = words[i].length() * words[j].length();
                if ((charSet[i] & charSet[j]) == 0) {
                    max = Math.max(max, production);
                }
            }
        }

        return max;
    }
}
