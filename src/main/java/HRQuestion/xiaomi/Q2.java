package HRQuestion.xiaomi;

import java.util.Deque;
import java.util.LinkedList;

public class Q2 {
    public static class MyTreeNode {
        public int val;
        public MyTreeNode left;
        public MyTreeNode right;
    }

    MyTreeNode builTree(String str) {
        if (str == null || str.length() == 0)
            return null;

        MyTreeNode root = new MyTreeNode();
        root.val = Integer.valueOf(str.substring(0, 1));
        String sub = str.substring(1);

        Deque<Character> stack = new LinkedList<>();
        return null;
    }
}
