package HRQuestion.huawei;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String first = myScanner.nextLine();
        String[] fs = first.split(" ");
        int N = Integer.valueOf(fs[0]);
        int ops = Integer.valueOf(fs[1]);
        int[] arr = new int[N + 1];
        String values = myScanner.nextLine();
        String[] valuesArr = values.split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(valuesArr[i - 1]);
        }
        for (int i = 0; i < ops; i++) {
            String myline = myScanner.nextLine();
            String[] foos = myline.split(" ");
            String op = foos[0];
            int aaa = Integer.valueOf(foos[1]);
            int bbb = Integer.valueOf(foos[2]);
            if (op.equals("Q")) {
                int sum = 0;
                for (int j = aaa; j <= bbb; j++) {
                    sum += arr[j];
                }
                System.out.println(sum / (bbb - aaa + 1));
            }
            if (op.equals("U")) {
                arr[aaa] += bbb;
            }
        }
    }
}

/*
6 4
1 2 3 4 5 6
Q 1 6
U 2 6
U 4 3
Q 1 2
* */