package offer;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class O6PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Deque<Integer> stack = new LinkedList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //ArrayList<Integer> list = new ArrayList<>(stack);
        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (!stack.isEmpty())
            list.add(stack.poll());
        return list;
    }

    public ArrayList<Integer> printListFromTailToHeadIter(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            list.addAll(printListFromTailToHeadIter(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode listNode = new ListNode(nums[0]);
        listNode.next = new ListNode(nums[1]);
        listNode.next.next = new ListNode(nums[2]);
        O6PrintListFromTailToHead solution = new O6PrintListFromTailToHead();
        ArrayList<Integer> list = solution.printListFromTailToHeadIter(listNode);
        System.out.println(list);


    }
}
