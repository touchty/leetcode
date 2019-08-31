package HRQuestion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q360_2_1 {
    public static int appearNumberI(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    public static int maxChar(String str) {
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
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
                    if (max == str.length())
                        return max;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int res = maxChar(str);
            System.out.println(res);
        }
       /* String str = "aba";
        int res = appearNumber(str, "a");
        System.out.println(res);*/
    }
}
