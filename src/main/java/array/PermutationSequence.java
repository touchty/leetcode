package array;

import java.util.LinkedList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> num = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }

        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        k = k - 1;
        for (int i = n; i > 0; i--) {
            int index = k / factorials[i - 1];
            k = k % factorials[i - 1];
            stringBuilder.append(num.get(index));
            num.remove(index);
        }
        return stringBuilder.toString();
    }
}
