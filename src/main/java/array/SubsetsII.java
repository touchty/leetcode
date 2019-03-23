package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int size = 0, startIndex = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            int n = nums[cur];
            startIndex = cur >= 1 && nums[cur] == nums[cur - 1] ? size : 0;
            size = result.size();
            for (int i = startIndex; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
