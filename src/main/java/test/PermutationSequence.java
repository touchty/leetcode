package test;

import java.util.ArrayList;

// 第k个排列
public class PermutationSequence {
    // n = 4 {1234,1243,1324,1342, ..., 4321}
    // k = 2
    // return 1243
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i-1] * i;
        }

        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        StringBuilder builder = new StringBuilder();
        k--;
        // 返回的字符串长度为n
        // 原理是每次找到最高位，然后减去比当前数字小的部分
        for (int i = 1; i <= n; i++) {
            int index = k / factorials[n - i];
            builder.append(String.valueOf(num.get(index)));
            num.remove(index);
            k -= index * factorials[n - i]; // 每次找到最高位，然后减去比当前数字小的部分
        }


        return builder.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        int[] ks = new int[24];
        PermutationSequence solution = new PermutationSequence();
        for (int i = 0; i < ks.length; i++) {
            ks[i] = i+1;

        }
        String[] res = new String[24];
        for (int i = 0; i < 24; i++) {
            res[i] = solution.getPermutation(n, i+1);
        }

        for (String s : res)
            System.out.println(s);
    }
}
