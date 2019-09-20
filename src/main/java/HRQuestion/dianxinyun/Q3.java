package HRQuestion.dianxinyun;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    static int maxSub(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int i : nums) {
            currentMax = Math.max(i, currentMax + i);
            max = Math.max(currentMax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        String s = scanner.next();
        s = s.substring(1, s.length() - 1);
        String[] strings = s.split(",");
        for (String s1 : strings)
            list.add(Integer.valueOf(s1));
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        System.out.println(maxSubArraySum(a));*/

        List<Integer> list = new ArrayList<>();

        String s = "[1, 2, -2, 3, 4]    ";
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        String[] strings = s.split(",");
        for (String s1 : strings)
            list.add(Integer.valueOf(s1.trim()));
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
            System.out.println(a[i]);
        }
        System.out.println(Integer.valueOf("2"));
        /*String s = "[1,2,-2,3]";
        String[] strings = s.split(",|]|\\[");
        for (String s1: strings)
            System.out.println(s1);*/
    }
}
