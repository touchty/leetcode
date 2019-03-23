package string;

import java.util.ArrayList;
import java.util.List;

/*
784. Letter Case Permutation
Easy

547

67

Favorite

Share
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(S, builder, 0, list);
        return list;
    }

    void helper(String S, StringBuilder builder, int index, List<String> list) {
        if (index == S.length()) {
            list.add(builder.toString());
            return;
        }
        builder.append(Character.toLowerCase(S.charAt(index)));
        helper(S, builder, index+1, list);
        if (Character.toLowerCase(S.charAt(index)) != Character.toUpperCase(S.charAt(index))) {
            builder.setCharAt(index, Character.toUpperCase(S.charAt(index)));
            helper(S, builder, index+1, list);
        }
        builder.deleteCharAt(index);
    }

    class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> ans=new ArrayList<>();
            compute(ans,S.toCharArray(),0);
            return ans;
        }

        public void compute(List<String> ans, char[] chars, int index)
        {
            if(index==chars.length)
                ans.add(new String(chars));
            else
            {
                if(Character.isLetter(chars[index]))
                {
                    chars[index]=Character.toLowerCase(chars[index]);
                    compute(ans,chars,index+1);
                    chars[index]=Character.toUpperCase(chars[index]);
                }
                compute(ans,chars,index+1);
            }
        }
    }
    public static void main(String[] args) {
        String S = "a1b2";
        LetterCasePermutation permutation = new LetterCasePermutation();
        List<String> list = permutation.letterCasePermutation(S);
        System.out.println(list);
    }
}
