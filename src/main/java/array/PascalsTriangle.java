package array;

import java.util.*;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return triangle;
        }

        ArrayList<Integer> first = new ArrayList<>(1);
        first.add(1);

        triangle.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = new ArrayList<>(prev.size() + 1);
            curr.add(1);
            for (int j = 0; j <= prev.size() - 2; j++) {
                curr.add(prev.get(j) + prev.get(j+1));
            }
            curr.add(1);
            triangle.add(curr);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRow = 5;
        List<List<Integer>> res = generate(numRow);
        System.out.println(res.size());
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
