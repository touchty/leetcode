package algorithms;

import java.util.Arrays;

public class ContainsDuplicateIII {
    /*public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if ((long)nums[i] - (long)nums[j] <= (long)t && (long)nums[i] - (long)nums[j] >= (long)-t)
                    return true;
            }
        }
        return false;
    }*/
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k < 1 || t < 0) return false;
        ValuePosPair[] valPosArr = new ValuePosPair[nums.length];
        for (int i = 0; i < nums.length; i++) valPosArr[i] = new ValuePosPair(nums[i], i);
        Arrays.sort(valPosArr);
        for (int i = 0; i < valPosArr.length; i++) {
            for (int j = i + 1; j < valPosArr.length && ((long) valPosArr[j].val - (long) valPosArr[i].val <= (long) t); j++) {
                if (Math.abs(valPosArr[j].pos - valPosArr[i].pos) <= k) return true;
            }
        }
        return false;
    }

    static class ValuePosPair implements Comparable<ValuePosPair> {

        int val;
        int pos;

        ValuePosPair(int v, int p) {
            val = v;
            pos = p;
        }

        public int compareTo(ValuePosPair x) {
            if (this.val == x.val) return 0;
            else if (this.val < x.val) return -1;
            else return 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2147483647, -2147483647};
        int k = 1;
        int t = 2147483647;
        boolean res = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(res);
    }
}

