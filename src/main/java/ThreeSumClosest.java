import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        assert (nums.length >= 3);  // Illigal input
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > target)
                    k--;
                else
                    j++;

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                    if (result == target) return target;
                }
            }
        }
        return result;
    }

    public int threeSumClosestOp(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        if (n <= 3) {
            for (int num : nums)
                res += num;
            return res;
        }

        res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - res) >= Math.abs(target - sum)) {
                    res = sum;
                    if (res == target) return res;
                }
                if (sum > target) k--;
                else if (sum < target) j++;
            }
        }
        return res;
    }

    public int threeSumClosestOptmized(int[] nums, int target) {
        int result = Integer.MAX_VALUE, n = nums.length;
        if (n > 2) {
            // #0-数组排序
            Arrays.sort(nums);
            // #1-计算所有组合中的全局最小值与全局最大值
            int less = nums[0] + nums[1] + nums[2];
            int more = nums[n - 3] + nums[n - 2] + nums[n - 1];
            // #1.1-如果全局最小值比target大
            if (less >= target)
                return less;
            // #1.2-如果全局最大值比target小
            if (more <= target)
                return more;
            // #2-计算以nums[i]开头的组合
            for (int i = 0; i < n - 2; i++) {
                // #2.1-计算局部组合之和的最小值与最大值
                int min = nums[i] + nums[i + 1] + nums[i + 2];
                int max = nums[i] + nums[n - 2] + nums[n - 1];
                // #2.2-如果最小值比target大，则更新全局最大值
                if (min > target) {
                    more = Math.min(more, min);
                    continue;
                }
                // #2.3-如果最大值比target小，则更新全局最小值
                if (max < target) {
                    less = Math.max(less, max);
                    continue;
                }
                // #2.4-如果min<=target<=max
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > target) {
                        more = Math.min(more, sum);
                        while (j < --k && nums[k] == nums[k + 1]) ;
                    } else if (sum < target) {
                        less = Math.max(less, sum);
                        while (++j < k && nums[j] == nums[j - 1]) ;
                    } else {
                        return target;
                    }
                }
            }
            if (less == target || more == target)
                return target;
            result = more - target > target - less ? less : more;
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int result = tsc.threeSumClosest(new int[]{1, 1, 1, 0}, 100);
        System.out.println(result);
    }
}