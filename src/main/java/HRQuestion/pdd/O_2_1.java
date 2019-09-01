package HRQuestion.pdd;

import java.util.*;

public class O_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] parse = str.split(",|;");
            for(int i = 0; i < parse.length - 1; i++)
                list.add(Integer.valueOf(parse[i]));
            int N = Integer.valueOf(parse[parse.length - 1]);
            list = sort(list);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                builder.append(list.get(i)).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.toString());
        }
    }

    public static List<Integer> sort(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 == 1)
                    return -1;
                if (o1 % 2 == 1 && o2 % 2 == 0)
                    return 1;
                return
                        o2 - o1;
            }
        });

        return list;
    }
}
