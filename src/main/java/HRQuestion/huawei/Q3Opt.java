package HRQuestion.huawei;

public class Q3Opt {
    int[] BIT;
    int n;

    public Q3Opt() {
        n = 1024;
        BIT = new int[n + 1];
    }

    public void init(int val) {
        while (val <= n) {
            BIT[val] += 1;
            val += (val & -val);
        }
    }

    public int getLess(int i) {
        int cnt = 0;
        i--;
        while (i > 0) {
            cnt += BIT[i];
            i -= (i & -i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3, 5};
        Q3Opt solution = new Q3Opt();
        int[] less = new int[nums.length];
        int[] equals = new int[nums.length];
        int[] large = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            less[i] = solution.getLess(nums[i]);
            equals[i] = solution.getLess(nums[i] + 1) - less[i];
            large[i] = i - (less[i] + equals[i]);
            //System.out.println(less[i]);
            //System.out.println(equals[i]);
            System.out.println(large[i]);
            solution.init(nums[i]);
        }
    }
}
