package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
386. Lexicographical Numbers
Medium

332

53

Favorite

Share
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                if (10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }

    public static void main(String[] args) {
        int n = 13;
        List<Integer> list = new LexicographicalNumbers().lexicalOrder(n);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.size() == n);
    }
}
