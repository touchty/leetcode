package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            int p1 = 0, p2 = path.indexOf(' ');
            if (p2 == -1) continue;
            String dirName = path.substring(p1, p2);
            p1 = p2 + 1;
            p2 = path.indexOf(')', p1);
            while (p2 != -1) {
                int mid = path.indexOf('(', p1);
                String fileName = path.substring(p1, mid);
                String content = path.substring(mid + 1, p2);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(dirName + '/' + fileName);
                p1 = p2 + 2;
                p2 = path.indexOf(')', p1);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String content : map.keySet()) {
            List<String> temp = map.get(content);
            if (temp.size() > 1) res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"};
        List<List<String>> files = FindDuplicateFileinSystem.findDuplicate(paths);
        for (List<String> list : files) {
            System.out.println(list);
        }
    }
}
