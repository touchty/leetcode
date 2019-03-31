package array;

/*
42. Trapping Rain Water
Hard

3192

59

Favorite

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6


 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * */
public class TrappingRainWater {
    public int trap(int A[]) {
        int n = A.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while (left <= right) {
            // fill from left if left is lower than right
            //         //
            //  \\   //
            //   \\//
            // fill water in the bottom of 'V'
            if (A[left] <= A[right]) {
                if (A[left] >= maxleft) maxleft = A[left];
                else res += maxleft - A[left];
                left++;
            } else {
                if (A[right] >= maxright) maxright = A[right];
                else res += maxright - A[right];
                right--;
            }
        }
        return res;
    }

    // https://leetcode.com/problems/trapping-rain-water/discuss/17527/My-Accepted-Java-Solution
    /*
                      top index
                    //\\
                   //  \\
                 //     \\      //
      \\       //        \\   //
        \\   //           \\//
          \\//
     */
    public int trapOpt(int[] height) {
        if (height.length <= 2) return 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = height[0];
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];
            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }
        }

        return water;
    }

    public int trapOpt1(int[] height) {
        int left = 0;
        int right = 0;
        int low = 0;
        int high = height.length - 1;
        int ans = 0;
        while(low < high){
            left = Math.max(left,height[low]);
            right = Math.max(right, height[high]);
            if(left < right){
                ans += left - height[low];
                low++;
            }else{
                ans += right - height[high];
                high--;
            }
        }
        return ans;
    }
}
