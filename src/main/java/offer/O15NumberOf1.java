package offer;

public class O15NumberOf1 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        O15NumberOf1 solution = new O15NumberOf1();
        int[] nums = {0, 1, 2, 3, -1, -2, -3, -4, -5, -6, Integer.MIN_VALUE};
        int[] cnts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnts[i] = solution.NumberOf1(nums[i]);
            System.out.println(cnts[i]);
        }
        int foo = Integer.MIN_VALUE;
        foo = foo - 1;
        System.out.println(foo);
        System.out.println(Integer.MAX_VALUE);
    }

    // BIT COUNT
//    public int NumberOf1(int n) {
//        return Integer.bitCount(n);
//    }
}
