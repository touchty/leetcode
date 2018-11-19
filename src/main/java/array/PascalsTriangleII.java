package array;

import java.util.*;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 */
public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        if (rowIndex < 0) return prev;
        prev.add(1); // initial row, for rowIndex = 0
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1); // start
            for (int j = 0; j <= prev.size() - 2; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1); // end
            prev = curr; // swap curr to prev to reduce memo comsuming
        }
        return prev;
    }

    public List<Integer> getRowOpt(int rowIndex) {
        int[] result = new int[1];
        //result[0] = 1;
        for(int i=0; i<=rowIndex; i++) {
            int[] next = new int[i+1];
            next[0] = 1; next[i] = 1;
            for(int j=1; j<i; j++) {
                next[j] = result[j-1] + result[j];
            }
            result = next;
            // System.out.println(result.toString());
        }
        List<Integer> ans = new ArrayList();
        for(int in : result)
            ans.add(in);
        return ans;
    }
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> res = getRow(rowIndex);
        System.out.println(res);
    }
}
