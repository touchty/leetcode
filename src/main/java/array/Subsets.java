package array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }

        /*for(int n : nums) {
            for (List<Integer> list : result) {
                System.out.println(list);
                List<Integer> subset = new ArrayList<>(list);
                subset.add(n);
                result.add(subset);  // modify the result List - throw exception
            }
        }*/
        return result;
    }
}
