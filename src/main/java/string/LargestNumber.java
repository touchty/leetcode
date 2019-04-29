package string;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (s1, s2) -> ((s2 + s1).compareTo(s1 + s2)));
        StringBuilder builder = new StringBuilder();
        for (String s : strings)
            builder.append(s);
        int i = 0;
        for ( ;i < builder.length(); i++) {
            if (builder.charAt(i) != '0') break;
        }
        if (i == builder.length()) return "0";
        return builder.substring(i);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        LargestNumber s = new LargestNumber();
        String res = s.largestNumber(nums);
        System.out.println(res);
    }
}
