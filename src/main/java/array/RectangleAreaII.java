package array;

import java.util.ArrayList;
import java.util.List;

/*
850. Rectangle Area II
Hard

150

21

Favorite

Share
We are given a list of (axis-aligned) rectangles.  Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the
coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.
Find the total area covered by all rectangles in the plane.  Since the answer may be too large, return it
modulo 10^9 + 7.
 */
public class RectangleAreaII {
    public int rectangleArea(int[][] rectangles) {

        int mod = (int) Math.pow(10, 9) + 7;
        long res = 0;
        List<int[]> recList = new ArrayList<>();
        for (int[] rec : rectangles)
            addRectangle(recList, rec, 0);

        for (int[] rec : recList)
            res = (res + ((long) (rec[2] - rec[0]) * (long) (rec[3] - rec[1]))) % mod;

        return (int) res % mod;
    }

    // Add new rectangle to the list. In case of overlap break up new rectangle into
    // non-overlapping rectangles. Compare the new rectanlges with the rest of the list.
    public void addRectangle(List<int[]> recList, int[] curRec, int start) {
        if (start >= recList.size()) {
            recList.add(curRec);
            return;
        }

        int[] r = recList.get(start);

        // No overlap
        if (curRec[2] <= r[0] || curRec[3] <= r[1] || curRec[0] >= r[2] || curRec[1] >= r[3]) {
            addRectangle(recList, curRec, start + 1);
            return;
        }

        if (curRec[0] < r[0])
            addRectangle(recList, new int[]{curRec[0], curRec[1], r[0], curRec[3]}, start + 1);

        if (curRec[2] > r[2])
            addRectangle(recList, new int[]{r[2], curRec[1], curRec[2], curRec[3]}, start + 1);

        if (curRec[1] < r[1])
            addRectangle(recList, new int[]{Math.max(r[0], curRec[0]), curRec[1], Math.min(r[2], curRec[2]), r[1]}, start + 1);

        if (curRec[3] > r[3])
            addRectangle(recList, new int[]{Math.max(r[0], curRec[0]), r[3], Math.min(r[2], curRec[2]), curRec[3]}, start + 1);
    }

    public static void main(String[] args) {
        int[][] rects = {{2, 0, 4, 2}, {0, 1, 3, 4}};
        RectangleAreaII solution = new RectangleAreaII();
        int area = solution.rectangleArea(rects);
        System.out.println(area);
    }
}
