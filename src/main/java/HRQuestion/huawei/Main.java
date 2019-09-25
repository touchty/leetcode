package HRQuestion.huawei;

import java.util.*;
public class Main {
    static int getEnd(int[] arr, int ss, int ee) {
        int key = arr[ee];
        int max = 1;
        int min = 0;
        for (int i = ss; i < ee; i++) {
            if (arr[i] > key) max++;
            else if (arr[i] < key) min++;
        }
        return min - max;
    }

    static int[] getMMMM(int[] arr, int count) {
        int total = 0;
        int myMax = 0;
        for (int i = 1; i < count; i++) {
            total += getEnd(arr, 0, i);
            myMax = Math.max(myMax, total);
        }
        return new int[]{myMax, total};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            int[] ps = getMMMM(arr, n);
            System.out.println(ps[0] + " " + ps[1]);
        }
    }
}