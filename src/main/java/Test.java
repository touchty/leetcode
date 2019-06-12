import java.io.*;
import java.util.*;
/**
 * Welcome to vivo !
 *
 */
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =  "11 5 8 22 9 5 0";
        String t = "3 5";
        int[] arrA = {3,5};
        int[] arrB = {11, 5, 8, 22, 9, 5 ,0};
        int m = arrA[0];
        int n = arrA[1];
        ListNode head = null;
        ListNode pre = null;
        for (int v : arrB) {
            ListNode listNode = new ListNode(v);
            if (head == null) {
                head = listNode;
            }
            if (pre != null) {
                pre.next = listNode;
            }
            pre = listNode;
        }
        solution(head, m, n);

    }

    /*private static void solution(ListNode head, int m, int n) {
        ListNode t = head;
        ListNode newH = new ListNode(-1);
        int[] vals = new int[n-m+1];
        for (int i = 0; i < m - 1; i++)
            t = t.next;
        for (int i = 0; i <= n-m; i++) {
            vals[i] = t.val;
            t = t.next;
        }
        ListNode p = newH;
        for (int i = n-m; i >= 0;i--){
            ListNode node = new ListNode(vals[i]);
            p.next = node;
            p = node;
        }
        newH = newH.next;
        p.next = t;
        if (m == 1)
            head = newH;

        ListNode temp = head;
        for (int i = 0; i < m - 2; i++)
            temp = temp.next;
        temp.next = newH;
        StringBuilder b = new StringBuilder();
        ListNode point = head;
        while (point != null) {
            b.append(point.val).append(" ");
            point = point.next;
        }
        System.out.println(b.toString());
        // TODO write your code here

    }*/

    private static void solution(ListNode head, int m, int n) {
        ListNode t = head;
        ListNode myHead = new ListNode(-1);
        int[] values = new int[n-m+1];
        for (int i = 0; i < m - 1; i++)
            t = t.next;
        for (int i = 0; i <= n-m; i++) {
            values[i] = t.val;
            t = t.next;
        }
        ListNode p = myHead;
        for (int i = n-m; i >= 0;i--){
            ListNode ptr = new ListNode(values[i]);
            p.next = ptr;
            p = ptr;
        }
        myHead = myHead.next;
        p.next = t;
        if (m == 1)
            head = myHead;

        ListNode temp = head;
        for (int i = 0; i < m - 2; i++)
            temp = temp.next;
        temp.next = myHead;
        StringBuilder myBuilder = new StringBuilder();
        ListNode position = head;
        while (position != null) {
            myBuilder.append(position.val).append(" ");
            position = position.next;
        }
        System.out.println(myBuilder.toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
            next = null;
        }

        public String toString() {
            String str = val + " ";
            ListNode node = next;
            while (node != null) {
                str += node.val + " ";
                node = node.next;
            }
            return str;
        }
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

}