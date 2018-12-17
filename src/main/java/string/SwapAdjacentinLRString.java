package string;

/**
 * 777. Swap Adjacent in LR String
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * Example:
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 */
// XXXXXL..... : L can be in any position of former X
// RXXXXX..... : R can be in any position of latter X
public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0, m = start.length(), n = end.length();
        if(m!=n) return false;
        while(i <= m && j <= n) { // This misses the corner case as mentioned and fixed by @crazyzzy
            while(i<m && start.charAt(i)=='X') i++;
            while(j<n && end.charAt(j)=='X') j++;
            if(i==m) {
                while(j<n && end.charAt(j)=='X') j++;
                return j==n;
            }else if(j==n) {
                while(i<m && start.charAt(i)=='X') i++;
                return i==m;
            }
            if((start.charAt(i)=='L' && end.charAt(j)=='L' && i >= j) ||
                    (start.charAt(i)=='R' && end.charAt(j)=='R' && i <= j)) {
                i++;
                j++;
            }
            else return false;
        }
        return true;
    }
}
