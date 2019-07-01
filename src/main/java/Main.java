// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Random;
import java.util.Scanner;
public class Main {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int curr = in.nextInt();
        curr--;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] res = {Integer.MAX_VALUE};
        dfs(nums, curr, new boolean[nums.length], 0, res);
        if (res[0] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res[0]);
    }
}