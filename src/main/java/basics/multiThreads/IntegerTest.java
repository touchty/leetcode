package basics.multiThreads;

public class IntegerTest {
    Integer I = 1;
    void foo(){
        I = I + 1;
        System.out.println(I);
    }


    public static void main(String[] args) {
        IntegerTest s = new IntegerTest();
        s.foo();
        s.foo();
    }
}
