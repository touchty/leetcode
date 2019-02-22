package linkedList;

import java.util.*;

/*
382. Linked List Random Node
Medium

322

95

Favorite

Share
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */
public class LinkedListRandomNode {
    private ListNode head;
    private Random rand;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int k = 1;
        ListNode node = this.head;
        int res = node.val;
        int i = 0;
        ArrayList<Integer> reservoir = new ArrayList<Integer>();

        while (i < k && node != null) {
            reservoir.add(node.val);
            node = node.next;
            i++;
        }
        i = k+1; // i == k  =>  i == k+1
        while (node != null) {
            if (rand.nextInt(i) < k) {
                reservoir.set(rand.nextInt(k), node.val);
            }
            i++;
            node = node.next;
        }
        return reservoir.get(0);// or return reservoir when k > 1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode pointer = head;
        pointer.next = new ListNode(2);
        pointer = head.next;
        pointer.next = new ListNode(3);
        pointer.next = new ListNode(3);
        LinkedListRandomNode randomNode = new LinkedListRandomNode(head);
        int N = 100;
        int[] samples = new int[N];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            samples[i] = randomNode.getRandom();
            sum += samples[i];
        }

        double average = sum / N;
        System.out.println(average);
    }
}
