package test;

import algorithms.IntegertoRoman;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    /**
     * initialize your data structure here.
     */
    public FindMedianfromDataStream() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        else
            return ((double) (small.peek() + large.peek())) / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums1 = {1,2,3,4,5};
        FindMedianfromDataStream solution = new FindMedianfromDataStream();
        FindMedianfromDataStream solution1 = new FindMedianfromDataStream();
        for (int i: nums)
            solution.addNum(i);
        for (int i : nums1)
            solution1.addNum(i);
        double m = solution.findMedian();
        double m1 = solution1.findMedian();

        System.out.println(m);
        System.out.println(m1);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */