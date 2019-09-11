package HRQuestion.xiaomi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q_qimiao3 {
    static String rm(String A, String B) {
        if (A == null)
            return null;
        if (B == null || B.length() == 0)
            return A;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < B.length(); i++) {
            set.add(B.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (!set.contains(A.charAt(i)))
                builder.append(A.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        /*String A = "AaBb";
        String B = "d";
        System.out.println(rm(A, B));*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();
            System.out.println(rm(A, B));
        }
    }
}
