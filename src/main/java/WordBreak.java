import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public boolean wordBreakRe(String s, List<String> dict) {
        boolean[] wb = new boolean[s.length() + 1];
        wb[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (wb[j] && dict.contains(s.substring(j, i)))
                    wb[i] = true;
            }
        }
        return wb[s.length()];
    }


    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s = "leetcode";
        //String[] array = {"leet", "code"};
        List<String> dict = new ArrayList<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wb.wordBreakRe(s, dict));
    }
}
