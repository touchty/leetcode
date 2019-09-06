package HRQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Amazon_1_1 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int powerQuest(int numOfLocations, List<Integer> calorificVal) {
        // WRITE YOUR CODE HERE
        int count = 0;
        for (int i : calorificVal) {
            String s = Integer.toBinaryString(i);
            if (isC(s))
                count += i;
        }
        return count;
    }

    static boolean isC(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(8);
        set.add(16);
        set.add(32);
        str = new StringBuilder().append(str).reverse().toString();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1' && !set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 20, 240, 256};
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int res = powerQuest(list.size(), list);
        System.out.println(res);
    }
}
