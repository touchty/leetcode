package offer;

import java.util.BitSet;

public class O50FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        BitSet bit1 = new BitSet(256);
        BitSet bit2 = new BitSet(256);

        for (int i = 0; i < str.length(); i++) {
            if (!bit1.get(str.charAt(i)))
                bit1.set(str.charAt(i));
            else
                bit2.set(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (bit1.get(str.charAt(i)) && !bit2.get(str.charAt(i)))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abacc";
        O50FirstNotRepeatingChar solution = new O50FirstNotRepeatingChar();
        int pos = solution.FirstNotRepeatingChar2(str);
        System.out.println(pos);
    }
}
