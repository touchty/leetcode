package offer;

public class O17Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number); // n位整数，包括前面的0000前缀
            return;
        }
        // 数组的0位是数字的最高位！！！
        // 0000 0001 0002 0003 ... 9999
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        // 第一个不为‘0’的位置开始
        while (index < number.length && number[index] == '0')
            index++;
        /*if (index == number.length)
            System.out.print('0');*/
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 2;
        O17Print1ToMaxOfNDigits s = new O17Print1ToMaxOfNDigits();
        s.print1ToMaxOfNDigits(n);
    }
}
