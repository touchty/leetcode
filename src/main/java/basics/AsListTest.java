package basics;

import java.util.Arrays;
import java.util.List;

public class AsListTest {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        List list = Arrays.asList(ints);
        System.out.println("list 的类型:" + list.get(0).getClass());
        System.out.println("list.get(0) == ints：" + list.get(0).equals(ints));

        Integer[] Ints = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> Ilist = Arrays.asList(Ints);
        System.out.println("list 的类型:" + list.get(0).getClass());
        System.out.println("list：" + Ilist);
        Ilist.add(100);
        System.out.println(Ilist);
    }
}