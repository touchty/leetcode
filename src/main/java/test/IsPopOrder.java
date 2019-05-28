package test;

import java.util.Deque;
import java.util.LinkedList;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < popA.length)  {
            if(stack.isEmpty() || stack.peek() != popA[j]) {
                if (i >= pushA.length) return false;
                stack.push(pushA[i++]);
            }else {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty() && i == pushA.length && j == popA.length;
    }

    public static void main(String[] args) {
        int[] pushA ={1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        IsPopOrder solution = new IsPopOrder();
        boolean res = solution.IsPopOrder(pushA, popA);
        System.out.println(res);
    }
}
