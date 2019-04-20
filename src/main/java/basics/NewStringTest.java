package basics;

public class NewStringTest {
    public static void main(String[] args) {
        String str = "abs";
        String s = new String(str);
        String s2 = new String(str);
        String s3 = new String("abc");
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s2 == s3);

        System.out.println(str.hashCode());
        System.out.println(System.identityHashCode(str));
        System.out.println(s.hashCode());
        System.out.println(System.identityHashCode(s));
        System.out.println(str == s);
        
    }
}
