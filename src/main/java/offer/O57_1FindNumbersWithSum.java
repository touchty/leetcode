package offer;

import java.util.ArrayList;

public class O57_1FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int s = array[i] + array[j];
            if (s == sum) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (s > sum) {
                j--;
            } else {
                i++;
            }
        }
        return new ArrayList<>();
    }
}
