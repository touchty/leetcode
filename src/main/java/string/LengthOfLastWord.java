package string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");

        if (splits.length > 0)
            return splits[splits.length - 1].length();
        else
            return 0;
    }

    public static int lengthOfLastWordOpt(String s) {
        int pos = s.length() - 1;
        int length = 0;
        while (pos >= 0 && s.charAt(pos) == ' ') {
            pos--;
        }

        while (pos >= 0) {
            if (s.charAt(pos--) != ' ')
                length++;
            else
                break;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "a abc";
        int res = LengthOfLastWord.lengthOfLastWordOpt(s);
        System.out.println(res);
    }
}
