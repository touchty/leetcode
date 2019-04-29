package array;

/*
lc 11 ContainerWithMostWater
Given n non-negative integers a 1, a 2, ..., a n , where each represents a point at coordinate (i, a i). n vertical
lines are drawn such that the two endpoints of line i is at (i, a i) and (i, 0).Find two lines, which together with x-axis forms a container, such that the container contains the most water. Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater s = new ContainerWithMostWater();
        int res = s.maxArea(height);
        System.out.println(res);
    }
}
