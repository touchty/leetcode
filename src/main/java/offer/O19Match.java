package offer;

//19. 正则表达式匹配
//NowCoder
//
//题目描述
//请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
//
//在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
//
//解题思路
//应该注意到，'.' 是用来当做一个任意字符，而 '*' 是用来重复前面的字符。这两个的作用不同，不能把 '.' 的作用和 '*' 进行类比，
// 从而把它当成重复前面字符一次。
public class O19Match {
    public static boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                match[0][i] = match[0][i - 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str[i] == pattern[j] || pattern[j] == '.')
                    match[i + 1][j + 1] = match[i][j];
                else if (pattern[j] == '*') {
                    // abc  str
                    // abc* pattern
                    if (j >= 1 && pattern[j - 1] == str[i] || pattern[j - 1] == '.') {
                        match[i + 1][j + 1] |= match[i + 1][j]; // single
                        match[i + 1][j + 1] |= match[i][j + 1]; // multiple
                        match[i + 1][j + 1] |= match[i + 1][j - 1]; // none
                    } else
                        match[i + 1][j + 1] |= match[i + 1][j - 1]; // none
                }
            }
        }
        return match[m][n];
    }

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern1 = "a.a".toCharArray();
        char[] pattern2 = "ab*ac*a".toCharArray();
        char[] pattern3 = "ab*a".toCharArray();
        boolean match1 = O19Match.match(str, pattern1);
        boolean match2 = O19Match.match(str, pattern2);
        boolean match3 = O19Match.match(str, pattern3);
        System.out.println(match1);
        System.out.println(match2);
        System.out.println(match3);
    }
}
