package sort;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStr, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (numStr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : numStr)
            sb.append(s);

        return sb.toString();
    }
}
