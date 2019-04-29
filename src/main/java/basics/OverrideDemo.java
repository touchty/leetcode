package basics;

import java.util.ArrayList;
import java.util.List;

public class OverrideDemo {
    static class SuperClass {
        protected List<Integer> func() throws Throwable {
            return new ArrayList<>();
        }
    }

    static class SubClass extends SuperClass {
        @Override
        public ArrayList<Integer> func() throws Exception {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        SubClass sub = new SubClass();

    }
}
