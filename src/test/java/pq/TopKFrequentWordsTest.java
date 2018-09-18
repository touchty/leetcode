package pq;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class TopKFrequentWordsTest {
    private TopKFrequentWords topKFrequentWords = new TopKFrequentWords();

    @Test
    public void topKFrequent() {
        String[] strs = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> res = topKFrequentWords.topKFrequent(strs, 2);
        String[] resA = new String[2];
        resA = res.toArray(resA);
        Assert.assertArrayEquals(resA, new String[]{"i", "love"});

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.offer(2);
        pq.offer(1);
        pq.offer(3);
        System.out.println(pq.poll());
        //  min heap
    }
}