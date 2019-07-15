package test;

import org.junit.Assert;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeMap;

// 1122 Relative Sort Array
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int index = 0;
        for (int n : arr2) {
            int count = map.get(n);
            map.remove(n);
            Arrays.fill(arr1, index, index + count, n);
            index += count;
        }

        NavigableSet<Integer> keySet = map.navigableKeySet();
        for (int key : keySet) {
            Arrays.fill(arr1, index, index + map.get(key), key);
            index += map.get(key);
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        RelativeSortArray solution = new RelativeSortArray();
        arr1 = solution.relativeSortArray(arr1, arr2);
        int[] expected = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        Assert.assertArrayEquals(expected, arr1);
    }
}
