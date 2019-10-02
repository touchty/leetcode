package HRQuestion.huawei;

import java.util.ArrayList;

public class Q3 {
    static int low(ArrayList<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    static int upper(ArrayList<Integer> list, int target) {
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    static int[] goals(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};

        int[] myGoals = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int indexLow = low(list, nums[i]);
            int indexUpper = upper(list, nums[i]);
            int low = indexLow + 1;
            int higher = list.size() - indexUpper;

            myGoals[i] = higher - low;
            list.add(indexUpper, nums[i]);
        }
        return myGoals;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        int[] myGoals = goals(nums);
        for (int g : myGoals) {
            System.out.println(g);
        }
    }
}

/*
2
3
1 3 2
3
2 1 3
 */
