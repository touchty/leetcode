package basics;

import edu.princeton.cs.algs4.In;

public class ANDNOT {
    public static void main(String[] args) {
        int CAPACITY = 5;

        for (int i = 0; i < 100; i++) {
            int state = i & ~CAPACITY;
            int count = i & CAPACITY;
            //System.out.println(state);
            System.out.println(count);
            //System.out.println(state + count);
        }
    }
}
