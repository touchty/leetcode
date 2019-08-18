package HRQuestion.pdd;

// 多多鸡 项链
public class Q2 {
    static int minDist(int L, int N, int[] nums) {
        int minCircularPathSum = Integer.MAX_VALUE;

        for (int i : nums) {
            int sum = 0;
            for (int j : nums) {
                int abs = Math.abs(j - i);
                sum += Math.min(abs, L - abs);
            }
            minCircularPathSum = Math.min(minCircularPathSum, sum);
        }

        // 逆向考虑，从最小距离中心点出发，向左向右到达对应的珍珠，每次偏移一位
        int k = (N - 1) / 2;
        int delta = k * (k + 1);
        if ((N - 1) % 2 == 1)
            delta += k + 1;
        return minCircularPathSum - delta;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 998, 995};
        int expected = 8;
        int move = Q2.minDist(1000, 4, nums);
        System.out.println(move);


        int[] nums1 = {1, 3, 8};
        int expected1 = 3;
        int move1 = Q2.minDist(10, 3, nums1);
        System.out.println(move1);
    }
}
