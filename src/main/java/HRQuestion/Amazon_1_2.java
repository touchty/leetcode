package HRQuestion;

import java.util.ArrayList;
import java.util.List;

public class Amazon_1_2 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<String> findAllcombinations(String dataString) {
        // WRITE YOUR CODE HERE
        List<String> list = new ArrayList<>();

        dfs(0, dataString, new StringBuilder(), list);
        return list;
    }
    // METHOD SIGNATURE ENDS

    static void dfs(int pos, String dataString, StringBuilder builder, List<String> list) {
        if (pos > builder.length())
            return;
        if (pos == dataString.length()) {
            list.add(builder.toString());
            return;
        }
        if (dataString.charAt(pos) != '?') {
            builder.append(dataString.charAt(pos));
            dfs(pos + 1, dataString, builder, list);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append('0');
            dfs(pos + 1, dataString, builder, list);
            builder.deleteCharAt(builder.length() - 1);

            builder.append('1');
            dfs(pos + 1, dataString, builder, list);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "0??0";
        List<String> list = findAllcombinations(str);
        System.out.println(list);
    }
}
