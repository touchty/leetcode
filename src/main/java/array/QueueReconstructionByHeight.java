package array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
                    if (a[0] - b[0] == 0) return a[1] - b[1];
                    else return b[0] - a[0];
                }
        );

        ArrayList<int[]> list = new ArrayList<>();
        for (int[] pair : people) {
            list.add(pair[1], pair);
        }

        /*for (int i = 1; i < people.length; i++) {
            int[] temp = people[i];
            int pos = i;
            while (pos != temp[1]) {
                people[pos] = people[pos - 1];
                pos--;
            }
            people[pos] = temp;
        }
        return people;*/

        return list.toArray(people);
    }

    public int[][] reconstructQueueOpt(int[][] a) {
        if (a.length == 0 || a[0].length == 0) {
            return new int[][]{};
        }
        int m = a.length;
        sort(a, 0, m - 1);
        List<int[]> list = new ArrayList<>();
        for (int i = m - 1; i >= 0; i--) {
            list.add(a[i][1], a[i]);
        }
        return list.toArray(new int[m][]);
    }

    private void sort(int[][] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        int[] mid = a[i + (j - i) / 2];
        while (i < j) {
            while (a[i][0] < mid[0] || (a[i][0] == mid[0] && a[i][1] > mid[1])) {
                i++;
            }
            while (a[j][0] > mid[0] || (a[j][0] == mid[0] && a[j][1] < mid[1])) {
                j--;
            }
            if (i <= j) {
                int[] tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        sort(a, i, r);
        sort(a, l, j);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] expected = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
        QueueReconstructionByHeight.reconstructQueue(people);

        for (int[] pair : people) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        Assert.assertArrayEquals(people, expected);
    }


}
