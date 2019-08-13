package offer;

// LC 91. Decode Ways
// 题目描述
//给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
// 一个数字有多种翻译可能，例如 12258 一共有 5 种，
// 分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
public class O46NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int cZero = '0';
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == cZero ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != cZero)
                dp[i + 1] += dp[i];

            if (s.charAt(i - 1) == cZero)
                continue;

            int prev = (s.charAt(i - 1) - cZero) * 10 + (s.charAt(i) - cZero);
            if (prev <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String number = "10";
        O46NumDecodings solution = new O46NumDecodings();
        int totalWays = solution.numDecodings(number);
        System.out.println(totalWays);
    }
}
