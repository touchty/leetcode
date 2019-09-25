import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ff = in.nextLine();
        String[] ffss = ff.split(" ");
        int N = Integer.valueOf(ffss[0]);
        int M = Integer.valueOf(ffss[1]);
        int[] arr = new int[N + 1];
        String str = in.nextLine();
        String[] strArr = str.split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(strArr[i - 1]);
        }
        for (int i = 0; i < M; i++) {
            String mystr = in.nextLine();
            String[] three = mystr.split(" ");
            String action = three[0];
            int p = Integer.valueOf(three[1]);
            int q = Integer.valueOf(three[2]);
            if (action.equals("U")) {
                arr[p] += q;
            }
            if (action.equals("Q")) {
                int sum = 0;
                for (int j = p; j <= q; j++) {
                    sum += arr[j];
                }
                System.out.println(sum / (q - p + 1));
            }
            
        }
    }
}
