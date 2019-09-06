import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 01 背包问题
public class Cost {
    static void solutition(int t, int[] A, int[] B) {
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            double[] p = new double[2];
            p[0] = i;
            p[1] = B[i] / (A[i] + 0.0);
            list.add(p);
        }

        Collections.sort(list, (a, b) -> (b[1] - a[1] >= 0.0001 ? 1 : -1));
        int scores = 0;
        while (t > 0) {
            if (list.size() == 0) break;
            int index = (int) list.get(0)[0];
            if (A[index] < t) {
                scores += B[index];
                t -= A[index];
            }
            list.remove(0);
        }
        System.out.println(scores);
    }

    public static void main(String[] args) {
        int t = 1000;
        int[] A = {200, 600, 100, 180, 300, 450};
        int[] B = {6, 10, 3, 4, 5, 8};
        Cost.solutition(t, A, B);
    }
}
