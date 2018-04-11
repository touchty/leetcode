import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1};

        int pos1 = Arrays.binarySearch(nums,1);
        int pos2 = Arrays.binarySearch(nums, 2);
        int pos3 = Arrays.binarySearch(nums, 3);

        System.out.println(pos1);
        System.out.println(pos2);
        System.out.println(pos3);
    }
}
