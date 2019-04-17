import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int minus = -1;
        System.out.println(Integer.toBinaryString(minus));
        int mask = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((mask & minus) != 0)
                res++;
            mask = mask << 1;
        }
        System.out.println(res);
    }
}
