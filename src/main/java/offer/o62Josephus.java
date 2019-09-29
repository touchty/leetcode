package offer;


// 约瑟夫环问题(Josephus)
public class o62Josephus {
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */ {
            return -1;
        }
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 3;
        System.out.println(LastRemaining_Solution(n, m));
    }
}
