package oop;

public class InheritationDemo {

    static class A {
        int id;
        public A(int id) {
            this.id = id;
        }
        String printName(){
            return String.valueOf(id);
        }
    }

    static class AImpl extends A{
        String name;
        /*int id;*/
        public AImpl(int id, String name) {
            super(id);
            this.name = name;
        }

        @Override
        String printName(){
            return name;
        }
    }

    public static void main(String[] args) {
        AImpl aImpl = new AImpl(0, "AImpl");
        A a = (A) aImpl;
        A aReal = new A(100);

        // Exception in thread "main" java.lang.ClassCastException: oop.InheritationDemo$A cannot be cast to oop.InheritationDemo$AImpl
        //AImpl aTest = (AImpl) aReal;


        System.out.println(aImpl.printName());
        System.out.println(a.printName());
        System.out.println(aReal.printName());
        //System.out.println(aTest.printName());
    }
}
