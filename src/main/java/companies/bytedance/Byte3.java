package companies.bytedance;

public class Byte3 {

    public static void main(String[] args) {
        int[] nums = {10, 0, 2, 1, 1, 0, 1};
        int curr = 3;
        int[] res = {Integer.MAX_VALUE};
        dfs(nums, curr, new boolean[nums.length], 0, res);
        if (res[0] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res[0]);
    }

    static boolean dfs(int[] nums, int curr, boolean[] visited, int steps, int[] max) {
        if (curr >= nums.length) {
            max[0] = Math.min(steps, max[0]);
            return true;
        }

        if (curr < 0 || curr > nums.length || visited[curr])
            return false;
        visited[curr] = true;
        for (int i = curr - nums[curr]; i <= curr + nums[curr]; i++) {
            dfs(nums, i, visited, steps + 1, max);
        }
        visited[curr] = false;
        return false;
    }
}
