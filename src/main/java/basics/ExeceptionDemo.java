package basics;

public class ExeceptionDemo {
    public static void main(String[] args) {
        try{
            int i = 1;
            int j = 0;
            int c = i / j;
            System.out.println(c);
        }catch (Exception e) {
            System.out.println("NOOOO");
        }

        System.out.println("hello");

    }
}
