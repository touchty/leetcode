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
