package test;

public class ReverseBits {
    static int reverse(int n) {
        System.out.println(Integer.toBinaryString(n));
        n = n ^ (-1);
        System.out.println(Integer.toBinaryString(n));
        return n;
    }
}
