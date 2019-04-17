package array;

public class Ones {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1346; i <= 21346; i++) {
            String s = Integer.toString(i);
            if (s.contains("1"))
                count++;
        }
        System.out.println(count);
    }
}
