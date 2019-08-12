package offer;

import java.util.ArrayList;
import java.util.Arrays;

// 题目描述
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

// 对于原始字符串含有重复元素的情况，如"aa"，答案应该是["aa"]，而不是["aa", "aa"]
public class O38Permutation {
    ArrayList<String> lists = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return lists;
        // 需要保证不重复
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        helper(chars, new boolean[chars.length], new StringBuilder());
        return lists;
    }

    private void helper(char[] str, boolean[] visited, StringBuilder builder) {
        if (builder.length() == str.length) {
            lists.add(builder.toString());
            return;
        }


        for (int j = 0; j < str.length; j++) {
            if (visited[j] || (j >= 1 && str[j - 1] == str[j] && !visited[j - 1]))
                continue;
            builder.append(str[j]);
            visited[j] = true;
            helper(str, visited, builder);
            visited[j] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String origin = "aab";
        O38Permutation solution = new O38Permutation();
        ArrayList<String> permutations = solution.Permutation(origin);
        System.out.println(permutations);
        int expectedLen = 1;
        System.out.println(expectedLen == permutations.size());
    }
}
