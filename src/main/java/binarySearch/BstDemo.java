package binarySearch;

import java.util.Arrays;

public class BstDemo {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int index = Arrays.binarySearch(nums, 4);
        System.out.println(index);
    }
}
