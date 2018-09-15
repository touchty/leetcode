public class ZigZagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("PAYPALISHIRING", 3);
        String result1 = solution.convert1("PAYPALISHIRING", 3);
        System.out.println(result);
        System.out.println(result1);
    }
}

class Solution {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);  // append other rows to the first row, constructing the answer
        return sb[0].toString();
    }

    public String convert1(String s, int nRows){
        char [] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] strBuf = new StringBuffer[nRows];
        for (int i = 0; i < strBuf.length; i++) strBuf[i] = new StringBuffer();


        int i = 0;
        while(i < len){
            // vertically down
            for (int idx = 0; idx < nRows && i < len; ++idx) {
                strBuf[idx].append(c[i++]);              
            }

            //obliquely up
            for (int idx = nRows - 2; idx >= 1 && i < len; --idx) {
                strBuf[idx].append(c[i++]);
            }

        }

        for (int idx = 1; idx < nRows; ++idx) {
                strBuf[0].append(strBuf[idx]);
        }

        String result = strBuf[0].toString();
        return result;
    }

}


