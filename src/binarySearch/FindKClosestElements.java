package binarySearch;

import java.util.*;

public class FindKClosestElements    {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        if(index < 0) index = -(index + 1);
        int i = index - 1, j = index;
        while(k-- > 0){
            if(i<0 || (j<arr.length && Math.abs(arr[i] - x) > Math.abs(arr[j] - x) ))j++;
            else i--;
        }
        List<Integer> result = new ArrayList();
        for (int e = i+1; e < j; e++)
            result.add(arr[e]);
        return result;
    }
}
