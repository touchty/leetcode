package test;


//
// 307. 区域和检索 - 数组可修改
public class LC307RangeSumQuery {
    private int[] b;
    private int len;
    private int[] nums;

    public LC307RangeSumQuery(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length / l);
        b = new int[len];
        for (int i = 0; i < nums.length; i++)
            b[i / len] += nums[i];
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += b[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void update(int i, int val) {
        int b_l = i / len;
        b[b_l] = b[b_l] - nums[i] + val;
        nums[i] = val;
    }
// Accepted

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        LC307RangeSumQuery solution = new LC307RangeSumQuery(nums);
        System.out.println(solution.sumRange(0, 2));
    }
}
