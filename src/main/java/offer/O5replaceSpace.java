package offer;

public class O5replaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                builder.append(' ').append(' ');
        }

        int end = builder.length() - 1;
        int index = str.length() - 1;
        while (index >= 0) {
            if (str.charAt(index) == ' ') {
                builder.setCharAt(end--, '0');
                builder.setCharAt(end--, '2');
                builder.setCharAt(end--, '%');
            } else {
                builder.setCharAt(end--, str.charAt(index));
            }
            index--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        O5replaceSpace solution = new O5replaceSpace();
        String str = "A B";
        String modified = solution.replaceSpace(new StringBuffer(str));
        System.out.println(modified);


        String str1 = "A B  C";
        String modified1 = solution.replaceSpace(new StringBuffer(str1));
        System.out.println(modified1);

        String str2 = "A B   ";
        String modified2 = solution.replaceSpace(new StringBuffer(str2));
        System.out.println(modified2);
    }
}
