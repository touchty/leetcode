public class A {
    public static class B{

    }

    public static void main(String[] args) {
        //B b = A.new B();
//        B b = new A().new B();
        B b = new A.B();
//        B b = new A().B;
    }
}
