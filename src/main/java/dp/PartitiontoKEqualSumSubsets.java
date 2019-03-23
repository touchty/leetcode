package dp;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {
    private boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1)
            return true;
        if (cur_sum == target && cur_num > 0)
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], cur_num + 1, target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }

}

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || sum < k) return false;
        sum = sum / k;
        return possible(nums, sum, new int[k], nums.length - 1);
    }

    boolean possible(int[] nums, int sum, int[] p, int idx) {
        //System.out.println(idx);
        if (idx == -1) {
            // for (int s : p) System.out.print(s + " ");
            //System.out.println();
            for (int s : p) if (s != sum) return false;
            return true;
        }

        int num = nums[idx];

        for (int i = 0; i < p.length; i++) {
            if (p[i] + num <= sum) {
                p[i] += num;
                if (possible(nums, sum, p, idx - 1)) return true;
                p[i] -= num;
            }
        }
        return false;
    }
}