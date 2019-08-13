package offer;

public class O56FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums)
            diff ^= num;

        diff &= -diff; // 00000...1000...00, the first 1 occurance from right
        for (int num : nums) {
            if ((num & diff) == 0)
                num1[0] ^= num;
            else num2[0] ^= num;
        }
    }
}
