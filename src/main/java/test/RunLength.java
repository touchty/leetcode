package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class RunLength {
    private static final int R    = 256;
    private static final int LG_R = 8;

    // Do not instantiate.
    private RunLength() { }

    /**
     * Reads a sequence of bits from standard input (that are encoded
     * using run-length encoding with 8-bit run lengths); decodes them;
     * and writes the results to standard output.
     */
    public static void expand() {
        boolean b = false;
        while (!BinaryStdIn.isEmpty()) {
            int run = BinaryStdIn.readInt(LG_R);
            for (int i = 0; i < run; i++)
                BinaryStdOut.write(b);
            b = !b;
        }
        BinaryStdOut.close();
    }

    /**
     * Reads a sequence of bits from standard input; compresses
     * them using run-length coding with 8-bit run lengths; and writes the
     * results to standard output.
     */
    public static void compress() {
        char run = 0;
        boolean old = false;
        while (!BinaryStdIn.isEmpty()) {
            boolean b = BinaryStdIn.readBoolean();
            if (b != old) {
                BinaryStdOut.write(run, LG_R);
                run = 1;
                old = !old;
            }
            else {
                if (run == R-1) {
                    BinaryStdOut.write(run, LG_R);
                    run = 0;
                    BinaryStdOut.write(run, LG_R);
                }
                run++;
            }
        }
        BinaryStdOut.write(run, LG_R);
        BinaryStdOut.close();
    }


    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbccccddef";
        StringBuilder builder = new StringBuilder();
        int MAX = 255;
        char c = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < MAX && s.charAt(i) == c) count++;
            else{
                builder.append(c).append(count);
                count = 1;
                c = s.charAt(i);
            }
        }
        System.out.println(builder.toString());
        double ratio = (double) builder.length() / s.length();
        System.out.println(ratio);
    }
}
