package string;

import java.util.Arrays;

/*
839. Similar String Groups
Hard

138

52

Favorite

Share
Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?

Example 1:

Input: ["tars","rats","arts","star"]
Output: 2
Note:

A.length <= 2000
A[i].length <= 1000
A.length * A[i].length <= 20000
All words in A consist of lowercase letters only.
All words in A have the same length and are anagrams of each other.
The judging time limit has been increased for this question.
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int[] parent = new int[A.length];
        int[][] diffs = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                // union
                if (isSimiliar(A[i], A[j])) union(parent, i, j);
                //int diff = diff(A[i], A[j]);
                //if (diff == 2) System.out.println(i + " : " + j);
            }
        }

        // union find, dfs
        for (int i = 0; i < A.length; i++) {
            dfs(parent, i);
        }

        Arrays.sort(parent);

        // Traverse the sorted array
        int res = 0;
        int n = parent.length;
        for (int i = 0; i < n; i++) {

            // Move the index ahead while
            // there are duplicates
            while (i < n - 1 &&
                    parent[i] == parent[i + 1]) {
                i++;
            }
            res++;
        }
        return res;
    }
    void union(int[] parent, int i, int j) {
        int p = dfs(parent, i);
        int q = dfs(parent, j);
        parent[p] = q;
    }
    int dfs(int[] parent, int node) {
        if (node == parent[node]) return node;
        parent[node] = dfs(parent, parent[node]);
        return parent[node];
    }

    boolean isSimiliar(String s, String t) {
        if (s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == t.charAt(i)) i++;
        while (i < j && s.charAt(j) == t.charAt(j)) j--;

        if (i < j && s.charAt(i) == t.charAt(j)) {
            i++;
            j--;
            while (i <= j) {
                if (s.charAt(i) == t.charAt(i)) i++;
                else return false;
            }
            return true;
        }
        return false;
    }

    int diff(String s , String t) {
        int res = 0;
        if (s.length() != t.length()) return -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) res++;
        }
        return res;
    }
    public static void main(String[] args) {
        //String[] A = {"tars", "rats", "arts", "star"};
        //String[] A = {"tars", "rats", "arts", "sart"};
        String[] A = {"kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc", "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"};
        SimilarStringGroups s = new SimilarStringGroups();
        int groups = s.numSimilarGroups(A);
        System.out.println(groups);
        /*System.out.println(s.isSimiliar("hello", "hlelo"));
        System.out.println(s.isSimiliar("hello", "hello"));*/
        System.out.println(s.isSimiliar(A[3], A[7]));
    }
}
