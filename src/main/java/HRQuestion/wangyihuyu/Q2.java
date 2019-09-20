package HRQuestion.wangyihuyu;

import java.util.*;

public class Q2 {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        // 在这里编写代码
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : list) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res.add(key);
            } else {
                res.add(key);
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        List<Integer> res = removeDuplicates(list);
        StringBuilder builder = new StringBuilder();
        for (int i : res)
            builder.append(i).append(" ");
        if (builder.length() > 0)
            builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }
}
