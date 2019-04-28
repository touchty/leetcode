package array;

import java.util.Arrays;

public class FirstOccuranceInSortedArray {
    static int firstPos(int[] A, int val) {
        int n = A.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        int high = n - 1;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2; //防止溢出
            if (val == A[mid]) {
                high = mid;   //如果找到了val,则继续对low~mid段数据进行二分查找
            } else if (val > A[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (A[high] == val) { //如果存在val，则high对应的值就是第一次出现的位置
            return high;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 4, 4};
        int[] array1 = {1};
        int pos = FirstOccuranceInSortedArray.firstPos(array, 3);
        int pos1 = FirstOccuranceInSortedArray.firstPos(array1, 1);
        System.out.println(pos);
        System.out.println(pos1);

        System.out.println(Arrays.binarySearch(array, 2));
    }
}
