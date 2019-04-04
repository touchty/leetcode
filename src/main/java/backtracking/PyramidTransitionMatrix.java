package backtracking;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
756. Pyramid Transition Matrix
Medium
We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:
Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
    A
   / \
  D   E
 / \ / \
X   Y   Z

This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
Example 2:
Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
Note:
bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap();
        for (String s : allowed) {
            map.putIfAbsent(s.substring(0, 2), new ArrayList()); //(A, B, C), C MUST BE IN THE TOP OF (A, B)
            map.get(s.substring(0, 2)).add(s.charAt(2));
        }
        List<Character> b = new ArrayList();
        for (char ch : bottom.toCharArray()) b.add(ch);
        return backtrack(0, b, new ArrayList(), map);

    }


    public boolean backtrack(int index, List<Character> level, List<Character> next, Map<String, List<Character>> map) {
        if (index == level.size() - 1) {
            if (next.size() == 1) return true;
            level = next;
            index = 0;
            next = new ArrayList();
        }
        char A = level.get(index);
        char B = level.get(index + 1);
        String prefix = A + "" + B;
        if (!map.containsKey(prefix)) return false;
        for (char ch : map.get(prefix)) {
            next.add(ch);
            if (backtrack(index + 1, level, next, map)) return true;
            next.remove(next.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String bottom = "XYZ";
        String[] allowed = {"XYD", "YZE", "DEA", "FFF"};
        List<String> allowedList = new ArrayList<>();
        for (String str : allowed) {
            allowedList.add(str);
        }
        PyramidTransitionMatrix solution = new PyramidTransitionMatrix();
        boolean isPyramid = solution.pyramidTransition(bottom, allowedList);
        boolean expected = true;
        Assert.assertEquals(expected, isPyramid);
    }
}
