class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s

        L = [''] * numRows
        index, step = 0, 1

        for x in s:
            L[index] += x
            if index == 0:
                step = 1
            elif index == numRows -1:
                step = -1
            index += step

        return ''.join(L)



yright © 1999-2019, CSDN.NET, All Rights Reserved



搜索博文/帖子/用户
  登录
LeetCode-468. 验证IP地址 Java 原
wangxizzz阅读数：2982018-09-07
问题描述
编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。

IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；

同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。

IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如, 2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。

然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (:😃 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。

同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。

说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。

示例 1:

输入: “172.16.254.1”

输出: “IPv4”

解释: 这是一个有效的 IPv4 地址, 所以返回 “IPv4”。
示例 2:

输入: “2001:0db8:85a3:0:0:8A2E:0370:7334”

输出: “IPv6”

解释: 这是一个有效的 IPv6 地址, 所以返回 “IPv6”。
示例 3:

输入: “256.256.256.256”

输出: “Neither”

解释: 这个地址既不是 IPv4 也不是 IPv6 地址。

class Solution {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 0) {
            return "Neither";
        }
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    private boolean isIPV4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] nums = IP.split("\\.");
        if (nums.length != 4) {
            return false;
        }
        for (String val : nums) {
            // 注意：192.0.0.1这种情况。当子串length>1，这是就不能以0开头。
            if ("".equals(val) || val.length() > 3 || (val.length() > 1 && val.charAt(0) == '0')) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                if (!(val.charAt(i) >= '0' && val.charAt(i) <= '9')) {
                    return false;
                }
            }
            if (Integer.parseInt(val) > 255) {
                return false;
            }
        }
        return true;
    }
    private boolean isIPV6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] nums = IP.toLowerCase().split("\\:");
        if (nums.length != 8) {
            return false;
        }
        for (String val : nums) {
            if (val.length() <= 0 || val.length() > 4) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                // 16进制的字母组合的IPV6地址
                if (c < '0' || ( c > '9' && c < 'a') || c > 'f') {
                    return false;
                }
            }
        }
        return true;
    }
}



# leetcode

3. Longest Substring Without Repeating Characters

424. Longest Repeating Character Replacement
滑动窗口

673. Number of Longest Increasing Subsequence
动态规划

128. Longest Consecutive Sequence
动态规划-MAP记录

1120. Maximum Average Subtree <===> 1123. Lowest Common Ancestor of Deepest Leaves
***类似的两个子树问题


TODO
813. Largest Sum of Averages

TODO
207. Course Schedule
拓扑排序

==有趣的排序
链接：https://www.nowcoder.com/questionTerminal/adc291e7e79f452c8b59243a5ce68d3a?toCommentId=765685
来源：牛客网
度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
任取数组中的一个数然后将它放置在数组的最后一个位置。
问最少操作多少次可以使得数组从小到大有序？
输入描述:
首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
输出描述:
输出一个整数表示最少的操作次数。
https://www.nowcoder.com/questionTerminal/adc291e7e79f452c8b59243a5ce68d3a?toCommentId=765685

ALGO. 单调队列 MonotoneIncreasing
[a0 ,a1, ..., an],如果 i <= j, ai <= aj, 返回(j-i)可能的最大值

ALGO. 元素差值的最大最小值，绝对值的最大最小值
一个数组[a1,a2,a3....an]，要求出令i <= j, aj-ai 最大值, 最小值, 绝对值的最大最小值
不断更新前面可能的最大最小元素
https://www.geeksfo




# Python3 program to conStruct a  
# binary tree from the given String  

  
# Helper class that allocates a new node 

class newNode: 

    def __init__(self, data): 

        self.data = data  

        self.left = self.right = None

  
# This funtcion is here just to test  

def preOrder(node): 

    if (node == None):  

        return

    print(node.data, end = " ")  

    preOrder(node.left)  

    preOrder(node.right) 

  
# function to return the index of  
# close parenthesis  

def findIndex(Str, si, ei): 

    if (si > ei):  

        return -1

  

    # Inbuilt stack  

    s = [] 

    for i in range(si, ei + 1): 

  

        # if open parenthesis, push it  

        if (Str[i] == '('):  

            s.append(Str[i])  

  

        # if close parenthesis  

        elif (Str[i] == ')'):  

            if (s[-1] == '('): 

                s.pop(-1)  

  

                # if stack is empty, this is  

                # the required index  

                if len(s) == 0:  

                    return i 

    # if not found return -1  

    return -1

  
# function to conStruct tree from String  

def treeFromString(Str, si, ei): 

      

    # Base case  

    if (si > ei):  

        return None

  

    # new root  

    root = newNode(ord(Str[si]) - ord('0')) 

    index = -1

  

    # if next char is '(' find the  

    # index of its complement ')'  

    if (si + 1 <= ei and Str[si + 1] == '('):  

        index = findIndex(Str, si + 1, ei)  

  

    # if index found  

    if (index != -1): 

  

        # call for left subtree  

        root.left = treeFromString(Str, si + 2,  

                                     index - 1)  

  

        # call for right subtree  

        root.right = treeFromString(Str, index + 2,  

                                            ei - 1) 

    return root 

  
# Driver Code  

if __name__ == '__main__': 

    Str = "4(2(3)(1))(6(5))"

    root = treeFromString(Str, 0, len(Str) - 1)  

    preOrder(root) 

// iqiyi q1
排列计数
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？

输入
第一行包含一个整数N，1<N≤1000。

第二行包含N-1个空格隔开的整数A1到AN-1，0≤Ai≤1

输出
输出符合要求的排列个数对109+7取模后的结果。


样例输入
4
1 1 0
样例输出
3

提示
样例解释

符合要求的排列为{3 2 1 4}、{4 2 1 3}和{4 3 1 2}。
规则
class Solution {
    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();

        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[N+1][N+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (S.charAt(i-1) == 'D') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int x: dp[N]) {
            ans += x;
            ans %= MOD;
        }

        return ans;
    }
}

// iqiyi q2
红蓝球
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
有一个非常经典的概率问题，是一个袋子里面有若干个红球和若干个蓝球，两个人轮流取出一个球，谁先取到红球谁就赢了，当人的先后顺序和球的数量确定时，双方的胜率都可以由计算得到，这个问题显然是很简单的。

现在有一个进阶版的问题，同样是一个袋子里面有n个红球和m个蓝球，共有A，B，C三人参与游戏，三人按照A，B，C的顺序轮流操作，在每一回合中，A，B，C都会随机从袋子里面拿走一个球，然而真正分出胜负的只有A，B两个人，没错，C就是来捣乱的，他除了可以使得袋子里面减少一个球，没有其他任何意义，而A，B谁 先拿到红球就可以获得胜利，但是由于C的存在，两人可能都拿不到红球，此时B获得胜利。

输入
输入仅包含两个整数n和m,表示红球和蓝球的数量，中间用空格隔开。(0<=n,m<=1000)

输出
请你输出A获胜的概率，结果保留5位小数。（四舍五入）


样例输入
1 1
样例输出
0.50000

提示
输入样例2
3 4
输出样例2
0.62857
规则


///////
import sys
 
def getWXFnumber(num1, num2):
    res = []
    if num1 < 0 or num2 > 999:
        return 0
    if num1 >= 0 and num2 <= 999:
        for i in range(num1, num2 + 1):
            tmp = []
            if len(str(i)) < 3 or len(str(i)) > 3:
                continue
            for j in range(len(str(i))):
                tmp.append(i // pow(10, j) % 10)
            getSum = pow(tmp[0], 3) + pow(tmp[1], 3) + pow(tmp[2], 3)
            if getSum == i:
                res.append(i)
            del tmp
    return res
 
 
if __name__ == '__main__':
    try:
        while True:
            arr1 = [int(t) for t in sys.stdin.readline().split()]
            res1 = getWXFnumber(arr1[0], arr1[1])
            if len(res1) >= 1:
                print(" ".join(str(i) for i in res1))
            if len(res1) == 0:
                print("no")
    except:
        pass
