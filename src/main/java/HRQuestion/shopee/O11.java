package HRQuestion.shopee;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class O11 {
    public static void main(String[] args) {
        List<String> x = letterCombinations("13");
        //System.out.println(x.toString());
        StringBuilder builder = new StringBuilder();
        for (String s: x)
            builder.append(s).append(" ");
        System.out.println(builder.toString());
        Scanner in = new Scanner(System.in);
        in.hasNextLine();
    }

    static String[] a = new String[]{"", "abc", "def",
            "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
    static StringBuffer sb = new StringBuffer();

    public static List<String> letterCombinations(String nums) {
        if (nums.length() == 0) {
            return null;
        }
        List<String> lists = new ArrayList<String>();

        dfs(nums, 0, lists);
        return lists;
    }

    private static void dfs(String nums, int n, List<String> answer) {
        if (n == nums.length()) {
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < a[nums.charAt(n) - '0'].length(); i++) {
            sb.append(a[nums.charAt(n) - '0'].charAt(i));
            dfs(nums, n + 1, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
