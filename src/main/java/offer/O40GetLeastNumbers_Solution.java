package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class O40GetLeastNumbers_Solution {
    private int partition(int[] nums, int l, int h) {
        int pivot = nums[l];
        int i = l;
        int j = h + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if (i == h)
                    break;
            }
            while (nums[--j] > pivot) {
                if (j == l)
                    break;
            }
            if (i > j)
                break;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    public void findKthSmallest(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return;

        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int p = partition(nums, l, h);
            if (p == k - 1)
                return;
            if (p < k - 1)
                l = p + 1;
            else
                h = p - 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public ArrayList<Integer> GetLeastNumbers_SolutionPQ(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 5;
        O40GetLeastNumbers_Solution solution = new O40GetLeastNumbers_Solution();
        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(nums, k);
        System.out.println(list);
    }


}
