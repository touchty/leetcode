package pq;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
480. Sliding Window Median
Hard

327

37

Favorite

Share
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class SlidingWindowMedian {
    // large number
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    // small number
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
            Comparator.reverseOrder()
    );

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private void add(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] res = slidingWindowMedian.medianSlidingWindow(nums, 4);
        for (double m : res)
            System.out.println(m);
    }
}
