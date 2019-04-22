package basics;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String objectFile = "C:\\tmp\\A.txt";
        /*A a1 = new A(123, "abc");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();
        a1.increase(11);
        System.out.println(a1.index);*/
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
        System.out.println(a2.index);
    }

    private static class A implements Serializable {

        private int x;
        private String y;
        public static int index = 0;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        void increase(int step){
            index += step;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }
}
