package array;

import java.util.ArrayList;
import java.util.List;

// 整数n去掉k位后的最大值
public class PunchK {
    List<Integer> maxVal(int n, int k) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) list.add(0);
        else {
            while (n > 0) {
                list.add(0, n % 10);
                n /= 10;
            }

        }
        puncture(list, k);
        return list;
    }

    private List<Integer> puncture(List<Integer> list, int k) {
        if (k >= list.size() || list.size() == 0) {
            list.clear();
            list.add(0);
            return list;
        }

        if (k == 0) return list;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                list.remove(i);
                return puncture(list, k - 1);
            }
        }
        // remove the last
        list.remove(list.size() - 1);
        return puncture(list, k - 1);
    }

    public static void main(String[] args) {
        int n = 001;
        int k = 2;
        PunchK solution = new PunchK();
        List<Integer> res = solution.maxVal(n, k);
        System.out.println(res);
    }
}
