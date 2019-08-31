package HRQuestion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q360_2_1 {
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        Pattern p = Pattern.compile(findText);
        Matcher m = p.matcher(srcText);
        while (m.find()) {
            count++;
        }
        return count;
    }
    public static int appearNumberI(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    public static int minSubString(String str) {
        Set<String> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                if (set.contains(sub))
                    break;
                else {
                    int occur = appearNumberI(str, sub);
                    if (occur <= max)
                        break;
                    max = Math.max(max, occur);
                    set.add(sub);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int res = minSubString(str);
            System.out.println(res);
        }
       /* String str = "aba";
        int res = appearNumber(str, "a");
        System.out.println(res);*/
    }
}
