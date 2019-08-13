package offer;


// 58.1 翻转单词顺序列
//NowCoder
//
//题目描述
//Input:
//"I am a student."
//
//Output:
//"student. a am I"
//解题思路
//题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，
// 需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
//
//正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
public class O58_1ReverseSentence {
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        O58_1ReverseSentence solution = new O58_1ReverseSentence();
        String reversed = solution.ReverseSentence(str);
        System.out.println(reversed);
    }
}
