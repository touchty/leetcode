import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.Complex;
import edu.princeton.cs.algs4.FFT;
public class Hello {
    public static void main(String[] args) {
        int pos = Arrays.binarySearch(new int[]{1,2,3,4,5,6,7,8}, 7);
        Complex[] data = new Complex[2];
        Complex i1 = new Complex(1,2);
        Complex i2 = new Complex(3,4);
        data[0] = i1;
        data[1] = i2;
        Complex[] fft = FFT.fft(data);
        System.out.println("No smoke!");
        for (Complex c : data)
            System.out.println(c);

        for (Complex c : fft)
            System.out.println(c);
        aMethod();
    }
    public static void aMethod(){
        var name = "Java 10";
        System.out.println(name);
    }
}
