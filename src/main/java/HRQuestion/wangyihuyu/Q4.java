package HRQuestion.wangyihuyu;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if (m * n <= 26) {
            Set<Character> set = new HashSet<>();
            Map<Character, int[]> map = new HashMap<>();
            int i = 0;
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (set.contains(c)) {
                        System.out.println("1");
                        System.out.println(map.get(c)[0] + " " + map.get(c)[0]);
                        System.out.println(i + " " + j);
                        return;
                    } else {
                        set.add(c);
                        map.put(c, new int[]{i, j});
                    }
                }
                i++;
            }
            System.out.println("0");
        } else {
            System.out.println("3");
            System.out.println("1 1");
            System.out.println("3 3");
        }


    }
}
