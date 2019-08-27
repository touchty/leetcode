package test;

import java.util.*;

// 递增数对的距离
public class MonotoneIncreasing {
    public static int maxDist(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int maxDist = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            // 前面小于等于nums[i]的元素集合
            SortedMap<Integer, Integer> less = map.headMap(nums[i] + 1);
            for (Map.Entry<Integer, Integer> e : less.entrySet()) {
                int j = e.getValue();
                maxDist = Math.max(maxDist, i - j);
            }
            // 保留最左的下标
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }
        return maxDist;
    }

    //单调队列
    static class Main {

        private static class Node {
            int index;
            int value;
        }

        /**
         * 朴素的想法，就是每个位置都去找它前面的数中，比它小，距离最远的，这样的解法是o(n^2)
         * <p>
         * 如果两个位置，data[a] < data[b]，并且a < b，b这个点是不应该进队列的，因为如果后面出现data[c]>data[b]
         * 那么肯定也有data[c]>data[a]，而且a<b，所以b压根就没有存在的价值
         * <p>
         * 所以我们维护一个单调递减的队列，如果遇到比队列更小的数，就直接插入
         * 反之，在队列中找到刚好比data[c]小或者等于data[c]，这个位置就是距离最远的
         * 复杂度是o(nlogn)
         */
        private static int run1(int[] data) {
            int ret = 0;
            //单调队列
            List<Node> queue = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                Node node = new Node();
                node.index = i;
                node.value = data[i];
                if (queue.size() == 0 || data[i] < queue.get(queue.size() - 1).value) {
                    queue.add(node);
                } else {
                    int pos = Collections.binarySearch(queue, node, (a, b) -> -Integer.compare(a.value, b.value));
                    if (pos < 0) {
                        pos = -(pos + 1);
                    }
                    ret = Math.max(ret, i - queue.get(pos).index);
                }
            }
            return ret;
        }

        /**
         * 其实可以有o(n)的解法的
         * 在单调队列中，不需要二分查找，而是根据上一次查找到的结果
         * 假设data[i-1]查到的结果是pos位置，那么data[i]至多从pos+1位置查起
         * 不然比ret还小，那还有查找的必要么
         */
        private static int run2(int[] data) {
            int ret = 0;
            //单调队列
            List<Node> queue = new ArrayList<>();
            int now = 0;
            for (int i = 0; i < data.length; i++) {
                Node node = new Node();
                node.index = i;
                node.value = data[i];
                if (queue.size() == 0 || data[i] < queue.get(queue.size() - 1).value) {
                    queue.add(node);
                } else {
                    //找到距离正好大于ret的
                    while (now + 1 < queue.size() && i - queue.get(now + 1).index > ret) {
                        now++;
                    }
                    while (now - 1 >= 0 && data[i] >= queue.get(now - 1).value) {
                        now--;
                    }
                    if (data[i] >= queue.get(now).value) {
                        ret = i - queue.get(now).index;
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        int maxDist = MonotoneIncreasing.maxDist(nums);
        System.out.println(maxDist);
    }
}
