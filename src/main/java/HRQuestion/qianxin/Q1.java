package HRQuestion.qianxin;

import java.util.*;

public class Q1 {
    static int count(int[] A, int[] P, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>(A.length);
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = map.getOrDefault(P[i], new LinkedList<>());
            list.add(A[i]);
            map.put(P[i], list);
        }

        int res = 0;
        if (start == 0)
            res = -1;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (queue.size() > 0) {
            int size = queue.size();
            res += size;
            for (int i = 0; i < size; i++) {
                int next = queue.poll();
                if (map.containsKey(next)) {
                    List<Integer> children = map.get(next);
                    map.remove(next);
                    for (int child : children) {
                        queue.offer(child);
                    }
                }

            }
        }
        return res;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ppidstr = sc.nextLine();
        String pidstr = sc.nextLine();
        int target = sc.nextInt();
        String[] ppidarr = ppidstr.split(" ");
        String[] pidarr = pidstr.split(" ");
        int[] ppid = new int[ppidarr.length];
        int[] pid = new int[ppid.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pidarr.length; i++) {
            ppid[i] = Integer.valueOf(ppidarr[i]);
            pid[i] = Integer.valueOf(pidarr[i]);
            if(!map.containsKey(pid[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(ppid[i]);
                map.put(pid[i], list);
            }else{
                List<Integer> list = map.get(pid[i]);
                list.add(ppid[i]);
                map.put(pid[i],list);
            }
        }
//        System.out.println(map);
        long count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < ppid.length; i++) {
            if(ppid[i] == target){
                count++;
            }
        }
        if(map.containsKey(target)){
            q.offer(target);
        }
//        System.out.println(count);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if(map.containsKey(num)){
                    List<Integer> list = map.get(num);
                    for (int j = 0; j < list.size(); j++) {
                        q.offer(list.get(j));
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    /*
3 1 5 21 10
0 3 3 1 5
5
    * */

    public static void main(String[] args) {
        int[] A = {3, 1, 5, 21, 10};
        int[] P = {0, 3, 3, 1, 5};
        int start = 0;
        int res = count(A, P, start);
        System.out.println(res);

        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String As = scanner.nextLine();
            String[] Ass = As.split(" ");
            int[] AA = new int[Ass.length];
            for (int i = 0; i < AA.length; i++) {
                AA[i] = Integer.valueOf(Ass[i]);
            }
            String Ps = scanner.nextLine();
            String[] Pss = Ps.split(" ");
            int[] PP = new int[Pss.length];
            for (int i = 0; i < AA.length; i++) {
                PP[i] = Integer.valueOf(Pss[i]);
            }
            String startStr = scanner.nextLine();
            int startP = Integer.valueOf(startStr);
            System.out.println(count(AA, PP, startP));
        }*/
    }
}
