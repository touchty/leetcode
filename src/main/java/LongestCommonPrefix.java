public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0)
            return prefix;

        // minimun length of str in strs
        int min = strs[0].length();
        for (String str : strs) {
            if (str.length() < min)
                min = str.length();
        }

        int pos = 0; // Last position of the common prefix

        boolean isCommonPrefix = true;

        while (pos < min) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(pos) != strs[0].charAt(pos))
                    isCommonPrefix = false;
            }
            if (!isCommonPrefix)
                break;
            else pos++;
        }

        prefix = strs[0].substring(0, pos);
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lss = new LongestCommonPrefix();
        String[] strs = new String[3];
        strs[0] = "abc";
        strs[1] = "abclmn";
        strs[2] = "abcefg";

        String prefix = lss.longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
