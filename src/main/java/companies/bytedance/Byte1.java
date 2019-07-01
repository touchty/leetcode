package companies.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Byte1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 1;
        Deque<Integer> queue = new LinkedList<>();
        Scanner in = new Scanner(System.in);
//        int K =  in.nextInt();
        int total = in.nextInt();
        int[] nums1 = new int[total];

        for (int i = 0; i < total; i++) {
            nums1[i] = in.nextInt();
        }
        // int K = in.nextInt();
        int K = in.nextInt();

        if (K >= total) System.out.println("null");
        int res = nums1[nums1.length - 1 - K];
        System.out.println(res);
    }
}
