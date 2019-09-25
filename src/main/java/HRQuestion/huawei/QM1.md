import java.util.*;

public class Main {
    static String myString(String SSS, String TTT) {
        StringBuilder b = new StringBuilder(SSS);
        int index = SSS.indexOf(TTT);
        if (index < 0)
            return SSS;
        for (int i = index; i < index + TTT.length(); i++) {
            b.setCharAt(i, '*');
        }
        return b.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t =  in.next();
        System.out.println(myString(s, t));
    }
}
