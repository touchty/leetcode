package offer;

//39. 数组中出现次数超过一半的数字
//NowCoder
//
//解题思路
//多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
//
//使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。如果前面查找了 i 个元素，且 cnt == 0，
// 说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
// 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
public class O39MoreThanHalfNum_Solution {
    // 占有鸽子巢穴原理
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = (nums[i] == majority) ? cnt + 1 : cnt - 1;
            // 如果cnt为0，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，
            // 但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
            // 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        // 统计最多的元素出现的次数
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 4, 3, 4, 4, 4, 6, 4};
        O39MoreThanHalfNum_Solution solution = new O39MoreThanHalfNum_Solution();
        int majority = solution.MoreThanHalfNum_Solution(nums);
        System.out.println(majority);
    }
}
