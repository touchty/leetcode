package array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        final int LEN = nums.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        while (i < LEN) {
            while (j < LEN) {
                if (nums[j] != nums[i])
                    break;
                j++;
            }
            int subLen = j - i;
            if (subLen > nums.length / 3)
                list.add(nums[i]);
            i = j;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        int[] expected = {1,2};
        List<Integer> res = majorityElement(nums);

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], (int)res.get(i));
        }
    }
}
