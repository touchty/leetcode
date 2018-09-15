package binarySearch;

import java.util.Arrays;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[Math.min(length1,length2)];
        int counter = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (p1 < length1 && p2 < length2){
            if (nums1[p1] == nums2[p2]) {
                result[counter] = nums1[p1];
                p1++;
                p2++;
                counter++;
            }
            else if (nums1[p1] > nums2[p2]){
                p2++;
            }
            else{
                p1++;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }
}
