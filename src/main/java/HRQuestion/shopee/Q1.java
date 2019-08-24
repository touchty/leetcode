package HRQuestion.shopee;

import java.util.ArrayList;

public class Q1 {
    ArrayList<String> charMap(String str) {
        ArrayList<String> lists = new ArrayList<>();
        dfs(str, 0, lists, new StringBuilder());
        return lists;
    }

    private void dfs(String str, int i, ArrayList<String> lists, StringBuilder builder) {
        if (i == str.length()) {
            lists.add(builder.toString());
        }


    }
}
