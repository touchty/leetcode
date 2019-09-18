


def findminsum(N):
    lennn = len(N)
    for i in range(1, lennn):
        a = N[i] + N[i - 1]
        b = N[i]
        TMPSUM = max(a, b)
        N[i] = TMPSUM
    return max(N)

if __name__=="__main__":
    alist = []
    input_num = input()
    input_num1 = input_num[1:len(input_num)-1]
    input_num2 = input_num1.split(',')
    for i in input_num2:
        alist.append(int(i))
    print(findminsum(alist))

def tyy2(s,t):

    sl = len(s)
    tl = len(t)
    if sl != tl:
        return False

    tar_d = {}
    for i in range(0,sl):
        v = t[i]
        k = s[i]

        if not tar_d.__contains__(s[i]):
            if v in tar_d.values():
                return False
            tar_d[k] = v
        else:
            if v != tar_d.get(k):
                return False
    return True

if __name__=="__main__":
    tmp = input()
    s = tmp.split(';')[0]
    t = tmp.split(';')[1]
    print(tyy2(s,t))




#include <stdio.h>
 
void calPalin(int iNum);
 
int main()
{
	int iNum;
 
	while (scanf("%d",&iNum)!=EOF)
	{
		if (iNum<=0)   
		{
			printf("Error Input!\n\n");
		}
		else
		{
			calPalin(iNum);
		}
	}
 
	return 0;
}
 
void calPalin(int iNum)
{
	int iHalfLen,iHalf,iDegree,iDigit,iResult; //iHalfLen是回文数对称左边有几位，如12521左边是3位数  
	//iHalf是回文数对称的左边一半，如12521中的125；iDegree表示几位数；
	//iDigit表示某一几位数有多少回文数，如3位数有90个； iResult是结果
	int i;
 
	iDigit=9;   //赋初值为9
 
	for (iDegree=1;;iDegree++)
	{
		if (iNum-iDigit<=0)  //该处=0时一定要退出！！
		{
			break;
		}
 
		iNum-=iDigit;
		if (iDegree%2==0)  //一位数和二位数中的回文数是一样多，三位数和四位数中也一样。。。
		{
			iDigit*=10;
		}				
	}
 
	iHalfLen=(iDegree+1)/2;   //算某一回文数左边的位数，如12521左边有3位
 
	iHalf=1;        //我觉得精华之所在
	for (i=2;i<=iHalfLen;i++)
	{
		iHalf*=10;         
	}
	iHalf+=iNum-1;
 
	iResult=iHalf;
	if (iDegree&1)  //如果是奇位数，那么右边比左边一半少一位
	{
		iHalf/=10;
	}
 
	while (iHalf)   //求最终结果
	{
		iResult=iResult*10+iHalf%10;
		iHalf/=10;
	}
 
	printf("The result is :   %d\n\n",iResult);
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
