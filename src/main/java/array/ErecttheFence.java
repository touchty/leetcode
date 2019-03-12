package array;

import java.util.*;

/*
587. Erect the Fence
Hard

126

140

Favorite

Share
There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.



Example 1:

Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]

Solution:
Graham scan
 */
public class ErecttheFence {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public List<Point> outerTrees(Point[] points) {
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) start = points[i];
        }
        Point curr = start;
        Set<Point> st = new HashSet<>();
        st.add(curr);
        List<Point> coll = new ArrayList<>();
        while (true) {
            Point fol = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == curr) continue;
                int val = crossProduct(curr, fol, points[i]);
                if (val > 0) {
                    fol = points[i];
                    coll = new ArrayList<>();
                } else if (val == 0) {
                    if (distance(curr, fol, points[i]) < 0) {
                        coll.add(fol);
                        fol = points[i];
                    } else coll.add(points[i]);
                }
            }
            for (Point p : coll) st.add(p);
            if (fol == start) break;
            st.add(fol);
            curr = fol;
        }
        return new ArrayList<Point>(st);
    }

    private int distance(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return ((y1 * y1 + x1 * x1) - (y2 * y2 + x2 * x2));
    }

    private int crossProduct(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        return (y2 * x1 - y1 * x2);
    }

    int ccw(Point a, Point b, Point c) {
        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
    }


    //https://leetcode.com/problems/erect-the-fence/discuss/103302/Java-Graham-scan-with-adapted-sorting-to-deal-with-collinear-points
    public static class Solution {

        public List<Point> outerTrees(Point[] points) {
            if (points.length <= 1)
                return Arrays.asList(points);
            sortByPolar(points, bottomLeft(points));
            Stack<Point> stack = new Stack<>();
            stack.push(points[0]); // previous point
            stack.push(points[1]); // current point
            for (int i = 2; i < points.length; i++) {
                Point top = stack.pop();
                while (ccw(stack.peek(), top, points[i]) < 0) // throw off top
                    top = stack.pop();
                stack.push(top);
                stack.push(points[i]);
            }
            return new ArrayList<>(stack);
        }

        private Point bottomLeft(Point[] points) {
            Point bottomLeft = points[0];
            for (Point p : points)
                if (p.y < bottomLeft.y || p.y == bottomLeft.y && p.x < bottomLeft.x)
                    bottomLeft = p;
            return bottomLeft;
        }

        /**
         * vector: a->b and a->c
         *
         * @return positive if counter-clockwise, negative if clockwise, 0 if collinear
         */
        int ccw(Point a, Point b, Point c) {
            return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
        }

        /**
         * @return distance square of |p - q|
         */
        private int dist(Point p, Point q) {
            return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
        }

        private void sortByPolar(Point[] points, Point r) {
            Arrays.sort(points, (p, q) -> {
                int compPolar = ccw(p, r, q);
                int compDist = dist(p, r) - dist(q, r);
                return compPolar == 0 ? compDist : compPolar;
            });
            // find collinear points in the end positions
            Point p = points[0], q = points[points.length - 1];
            int i = points.length - 2;
            while (i >= 0 && ccw(p, q, points[i]) == 0)
                i--;
            // reverse sort order of collinear points in the end positions
            for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
                Point tmp = points[l];
                points[l] = points[h];
                points[h] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        Point[] points1 = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            Point p = new Point(point[0], point[1]);
            points1[i] = p;
        }
        ErecttheFence fence = new ErecttheFence();
        List<Point> res = fence.outerTrees(points1);
        System.out.println("Result: ");
        for (Point p : res) {
            System.out.println("x:" + p.x + " y:" + p.y);
        }

        Solution s = new ErecttheFence.Solution();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            Point p = new Point(point[0], point[1]);
            points1[i] = p;
        }
        List<Point> resOpt = s.outerTrees(points1);
        System.out.println("Result: ");
        for (Point p : resOpt) {
            System.out.println("x:" + p.x + " y:" + p.y);
        }
    }
}
