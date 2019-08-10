package offer;

import java.util.Deque;
import java.util.LinkedList;

public class O31IsPopOrder {
    public static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        Deque<Integer> stack = new LinkedList<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushSequence.length; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < popSequence.length && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {5, 4, 3, 2, 1};
        int[] pop3 = push;
        int[] pop4 = {4, 3, 5, 1, 2};

        boolean match1 = O31IsPopOrder.IsPopOrder(push, pop1);
        boolean match2 = O31IsPopOrder.IsPopOrder(push, pop2);
        boolean match3 = O31IsPopOrder.IsPopOrder(push, pop3);
        boolean match4 = O31IsPopOrder.IsPopOrder(push, pop4);

        System.out.println(match1);
        System.out.println(match2);
        System.out.println(match3);
        System.out.println(match4);
    }
}
