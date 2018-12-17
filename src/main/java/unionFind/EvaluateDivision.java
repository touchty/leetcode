package unionFind;

import java.util.*;

/**
 * 399. Evaluate Division
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> parent = new HashMap<>();  //<node, parent of the node>
        Map<String, Double> ratio = new HashMap<>();   //<node, node / parent>
        for (int i = 0; i < equations.length; i++) {
            union(parent, ratio, equations[i][0], equations[i][1], values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0], s2 = queries[i][1];
            if (!parent.containsKey(s1) || !parent.containsKey(s2)
                    || !find(parent, ratio, s1).equals(find(parent, ratio, s2))) {
                res[i] = -1.0;
            } else {
                res[i] = ratio.get(s1) / ratio.get(s2);
            }
        }
        return res;
    }

    // relative ratio!
    private void union(Map<String, String> parent, Map<String, Double> ratio, String s1, String s2, double val) {
        if (!parent.containsKey(s1)) {
            parent.put(s1, s1);
            ratio.put(s1, 1.0);
        }
        if (!parent.containsKey(s2)) {
            parent.put(s2, s2);
            ratio.put(s2, 1.0);
        }
        String p1 = find(parent, ratio, s1);
        String p2 = find(parent, ratio, s2);
        parent.put(p1, p2);
        //ratio p1 vs p2
        // s1 / s2 = val
        // (1 / ratio.get(s1)) ---- p1
        ratio.put(p1, val * ratio.get(s2) * (1 / ratio.get(s1)));
    }

    private String find(Map<String, String> parent, Map<String, Double> ratio, String s) {
        if (s.equals(parent.get(s))) {
            return s;
        }
        String father = parent.get(s);
        String grandpa = find(parent, ratio, father);
        parent.put(s, grandpa);
        ratio.put(s, ratio.get(s) * ratio.get(father));
        return grandpa;
    }
    /*      s ratio
            c 1.0
           /
          b 3.0
         /
         a 6.0
        /
       d 24.0
     */

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}, {"d", "a"}, {"f", "e"}, {"e", "d"}};
        double[] values = {2.0, 3.0, 4.0, 7, 2};
        String[][] queries = {{"f", "c"}};
        double[] ratios = new EvaluateDivision().calcEquation(equations, values, queries);
        for (double ratio : ratios) {
            System.out.println(ratio);
        }
    }
}
