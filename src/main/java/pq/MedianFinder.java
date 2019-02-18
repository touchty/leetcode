package pq;

import org.junit.Assert;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> large = new PriorityQueue<>();
    private Queue<Integer> small = new PriorityQueue<>((a, b) -> (b.compareTo(a)));

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if (small.size() < large.size())
            small.add(large.poll());
    }

    public double findMedian() {
        return small.size() > large.size()
                ? small.peek()
                : (small.peek() + large.peek()) / 2.0;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        MedianFinder  medianFinder = new MedianFinder();
        for (int n : num) {
            medianFinder.addNum(n);
        }
        double median = medianFinder.findMedian();
        double expected = 3;
        Assert.assertEquals(expected, median, 1e-20);
    }
}
