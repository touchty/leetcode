package array;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(set);
        list.sort(Comparator.comparing(Map.Entry::getValue));

        List<Map.Entry<Integer, Integer>> entrys = list.subList(list.size() - k,list.size());

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entrys) {
            res.add(entry.getKey());
        }

        return res;
    }

    //bucket sort
    public List<Integer> topKFrequentOpt(int[] nums, int k) {

        int min = nums[0], max = nums[0];
        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        //can also use a hashmap
        int[] freq = new int[max-min + 1];
        int maxFreq = 0;
        for(int n : nums) {
            int diff = n - min;
            freq[diff]++;
            if (freq[diff] > maxFreq) maxFreq = freq[diff];
        }

        ArrayList<Integer> buckets[] = new ArrayList[maxFreq + 1];

        for(int i = 0; i < freq.length; i++){
            int f = freq[i];
            if(f == 0) continue;
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(i + min);
        }


        List<Integer> ans = new ArrayList<>();
        int j = buckets.length-1;

        while (ans.size() < k){
            if(buckets[j] == null){
                j--;
            }else if(k - ans.size() >= buckets[j].size()){
                ans.addAll(buckets[j--]);
            }else{
                for(int i = 0; i < k - ans.size(); i++){
                    ans.add(buckets[j].get(i));
                }
                break;
            }
        }
        return ans;

    }
}
