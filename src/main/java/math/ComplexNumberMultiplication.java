package math;

/*
537. Complex Number Multiplication
 */
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int[] first=toArray(a);
        int[] second=toArray(b);
        int[] ans=new int[2];
        ans[0]=first[0]*second[0]-first[1]*second[1];
        ans[1]=first[1]*second[0]+first[0]*second[1];
        sb.append(ans[0]).append('+').append(ans[1]).append('i');
        return sb.toString();
    }

    private int[] toArray(String a) {
        int[] ans=new int[2];
        ans[0]=Integer.parseInt(a.substring(0,a.indexOf('+')));
        ans[1]=Integer.parseInt(a.substring(a.indexOf('+')+1,a.indexOf('i')));
        return ans;
    }
}
