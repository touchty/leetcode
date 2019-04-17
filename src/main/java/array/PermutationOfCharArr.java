package array;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfCharArr {
    void permu(char[] A, int index, List<String> list) {
        if (index == A.length) {
            StringBuilder builder = new StringBuilder();
            for (char a : A)
                builder.append(a);
            list.add(builder.toString());
        }

        for (int i = index; i < A.length; i++) {
            swap(A, index, i);
            permu(A, index + 1, list);
            swap(A, index, i);
        }
    }

    void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        char[] A = {'a', 'b', 'c'};
        PermutationOfCharArr s = new PermutationOfCharArr();
        List<String> list = new ArrayList<>();
        s.permu(A, 0, list);
        System.out.println(list);
    }
}
