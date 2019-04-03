package array;

import java.util.Arrays;
import java.util.Comparator;

/*
757. Set Intersection Size At Least Two
An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.

Example 1:
Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
Output: 3
Explanation:
Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
Also, there isn't a smaller size set that fulfills the above condition.
Thus, we output the size of this set, which is 3.
Example 2:
Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
Output: 5
Explanation:
An example of a minimum sized set is {1, 2, 3, 4, 5}. */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
            }
        });

        int m = 0, largest = -1, second = -1;

        for (int[] interval : intervals) {
            int a = interval[0], b = interval[1];

            boolean is_largest_in = (a <= largest);
            boolean is_second_in = (a <= second);

            if (is_largest_in && is_second_in) continue;

            m += (is_largest_in ? 1 : 2);

            second = (is_largest_in ? largest : b - 1);
            largest = b;
        }

        return m;
    }

    public class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (interval1, interval2) -> (interval1[1] - interval2[1])); // sort by upper bounds (right edges).
            int max1 = -1, max2 = -1, ans = 0; // selected points are dummy (-1), so selected 0 points.
            for (int[] interval : intervals) {
                int start = interval[0], end = interval[1];
                if (start > max1) { // [Case1] no intersection with collected ones.
                    // end>start>max1>max2
                    ans += 2; // add 'max1' and 'max2'.
                    // Pick 2 number having difference by 1, because the more smaller the range is, the better.
                    max2 = end - 1; // Minimize the range of 2 numbers by greatest lower bounds.
                    max1 = end;
                } else if (start > max2) { // [Case2] has intersection
                    // [Candidates are]
                    // - end>   start>=max1>max2 // no need to add 'start'. Adding 'end' suffice 2 intersection.
                    // - end> max1> start  >max2 // no need to add 'start'. use 'max1' instead of 'start'.
                    // - end==max1> start  >max2 // no need to add 'start'. use 'max1'-1 instead of 'start'
                    ans++; // Increment by 1 (Additionally use 'end'.) (Either 'max1' or 'start' is used, but total number used is unchanged.)
                    max2 = max1 == end ? max1 - 1 : max1; // compare right edge then update 'max2'.
                    max1 = end; // update 'max1'
                }
                // [Case 3] end > max1 > start
                // 'max1' is already intersects with 'interval' and previous 'interval' from which 'max1' is collected.
                // This means 'max1' already intersects more than or equal to 2 times.
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};

        SetIntersectionSizeAtLeastTwo solution = new SetIntersectionSizeAtLeastTwo();
        int size = solution.intersectionSizeTwo(intervals);
        System.out.println(size);
    }
}
