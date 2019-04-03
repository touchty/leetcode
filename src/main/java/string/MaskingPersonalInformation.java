package string;

/*
831. Masking Personal Information
 */
public class MaskingPersonalInformation {
    String[] country = {"", "+*-", "+**-", "+***-"};

    public String maskPII(String S) {
        int at = S.indexOf("@");
        if (at > 0) {
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }

    public static void main(String[] args) {
        String[] Ss = {"LeetCode@LeetCode.com", "1(234)567-890"};
        MaskingPersonalInformation solution = new MaskingPersonalInformation();
        String[] manipulated = new String[Ss.length];
        for (int i = 0; i < Ss.length; i++) {
            manipulated[i] = solution.maskPII(Ss[i]);
        }
        for (String s : manipulated)
            System.out.println(s);
    }
}


