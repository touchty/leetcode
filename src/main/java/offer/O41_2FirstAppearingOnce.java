package offer;

import java.util.LinkedList;
import java.util.Queue;

// 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
// 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
public class O41_2FirstAppearingOnce {
    int[] cnt = new int[256];
    Queue<Character> queue = new LinkedList<>();

    public void insert(char c) {
        cnt[c]++;
        queue.offer(c);

        while (queue.size() > 0 && cnt[queue.peek()] > 1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }


}
