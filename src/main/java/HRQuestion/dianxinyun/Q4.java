package HRQuestion.dianxinyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q4 {
    List<Integer> kValues(LinkedList<Integer> list, int k) {
        Collections.sort(list);
        List<Integer> temp0 = list;
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < k; i++, flag = 1 - flag) {
            if (flag == 0) {
                int curr = 0;
                for (int t : temp0) {
                    if (t != 0) {
                        res.add(t);
                        curr = t;
                        break;
                    }
                }
                for (int t : temp0) {
                    if (t != 0)
                        temp1.add(t - curr);
                }
                temp0.clear();
            } else {
                int curr = 0;
                for (int t : temp1) {
                    if (t != 0) {
                        res.add(t);
                        curr = t;
                        break;
                    }
                }
                for (int t : temp1) {
                    if (t != 0)
                        temp0.add(t - curr);
                }
                temp1.clear();
            }
        }
        return res;
    }
}
