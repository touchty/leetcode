package string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length()))
            return false;
        // dp
        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0)
                    table[i][j] = true;
                else if (i == 0) {
                    table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                } else if (j == 0) {
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                } else {
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return table[s1.length()][s2.length()];
    }
}

/**
 * C++ VERSION
 * public:
 * bool isInterleave(string s1, string s2, string s3) {
 * <p>
 * if(s3.length() != s1.length() + s2.length())
 * return false;
 * <p>
 * bool table[s1.length()+1][s2.length()+1];
 * <p>
 * for(int i=0; i<s1.length()+1; i++)
 * for(int j=0; j< s2.length()+1; j++){
 * if(i==0 && j==0)
 * table[i][j] = true;
 * else if(i == 0)
 * table[i][j] = ( table[i][j-1] && s2[j-1] == s3[i+j-1]);
 * else if(j == 0)
 * table[i][j] = ( table[i-1][j] && s1[i-1] == s3[i+j-1]);
 * else
 * table[i][j] = (table[i-1][j] && s1[i-1] == s3[i+j-1] ) || (table[i][j-1] && s2[j-1] == s3[i+j-1] );
 * }
 * <p>
 * return table[s1.length()][s2.length()];
 * }
 */
