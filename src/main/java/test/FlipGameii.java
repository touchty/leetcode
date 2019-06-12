package test;

public class FlipGameii {
    static boolean canWin(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i) && s.charAt(i)=='+' && !canWin(s.substring(0, i-1) + "--" + s.substring(i+1)))
                return true;
        }
        return false;
    }

    static boolean canWin_Find(String s) {
        for (int i = -1; ((i = s.indexOf("++", i+1)) >= 0); ) {
            if (!canWin(s.substring(0, i) + "--" + s.substring(i+2)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "++++";
        boolean win = FlipGameii.canWin_Find(s);
        System.out.println(win);
    }
}
