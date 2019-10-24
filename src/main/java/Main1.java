import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int N = Integer.valueOf(in.nextLine());
        /*for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            String last5 = line.substring(6);
            if (set.contains(last5))
                System.out.println("000000");
            else {
                set.add(last5);
                System.out.println("6" + last5);
            }
        }*/

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String last5 = line.substring(6);
            if (set.contains(last5))
                System.out.println("000000");
            else {
                set.add(last5);
                System.out.println("6" + last5);
            }
        }
    }
}
