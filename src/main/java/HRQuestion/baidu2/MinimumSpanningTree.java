package HRQuestion.baidu2;

import java.util.*;

public class MinimumSpanningTree {
    static class DisSet {
        Set<String> set;
        Map<String, String> map;
        int count;

        public DisSet() {
            count = 0;
            set = new HashSet<>();
            map = new HashMap<>();
        }

        public void MakeMySet(String s) {
            if (!set.contains(s)) {
                count++;
                set.add(s);
                map.put(s, s);
            }
        }

        public String Find(String s) {
            if (!set.contains(s)) return null;
            if (s.equals(map.get(s))) return s;
            String root = this.Find(map.get(s));
            map.put(s, root);
            return root;
        }

        public void Union(String s, String t) {
            if (!set.contains(s) || !set.contains(t)) return;
            if (s.equals(t)) return;
            count--;
            map.put(s, t);
        }
    }

    static class Edge {
        String p1;
        String p2;
        int dist;

        public Edge(String a, String b, int c) {
            p1 = a;
            p2 = b;
            dist = c;
        }
    }

    static class EdgeC1 implements Comparator<Edge> {
        @Override
        public int compare(Edge a, Edge b) {
            return a.dist - b.dist;
        }
    }

    static class EdgeC2 implements Comparator<Edge> {
        @Override
        public int compare(Edge a, Edge b) {
            if (a.p1.equals(b.p1)) return a.p2.compareTo(b.p2);
            else return a.p1.compareTo(b.p1);
        }
    }


    public static List<Edge> mst(List<Edge> connections) {
        Comparator<Edge> c1 = new EdgeC1();
        Comparator<Edge> c2 = new EdgeC2();
        Collections.sort(connections, c1);
        DisSet set = new DisSet();
        List<Edge> res = new ArrayList<>();
        for (Edge itr : connections) {
            set.MakeMySet(itr.p1);
            set.MakeMySet(itr.p2);
        }
        for (Edge itr : connections) {
            String s = set.Find(itr.p1);
            String t = set.Find(itr.p2);
            if (!s.equals(t)) {
                set.Union(s, t);
                res.add(itr);
                if (set.count == 1) break;
            }
        }
        if (set.count == 1) {
            Collections.sort(res, c2);
            return res;
        } else return new ArrayList<Edge>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Edge> connections = new ArrayList<>();
        /*int m = 3;
        int n = 3;*/
        /*int[][] edges;*/
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] edges = new int[m + k][3];
            while (in.hasNextInt()) {
                for (int i = 0; i < m; i++) {
                    edges[i][0] = in.nextInt();
                    edges[i][1] = in.nextInt();
                    edges[i][2] = 0;
                }
                for (int i = m; i < m + k; i++) {
                    edges[i][0] = in.nextInt();
                    edges[i][1] = in.nextInt();
                    edges[i][2] = in.nextInt();
                }
            }
            for (int[] e : edges) {
                connections.add(new Edge(String.valueOf(e[0]), String.valueOf(e[1]), e[2]));
            }
            List<Edge> res = mst(connections);
            int sum = 0;
            for (Edge c : res) {
                sum += c.dist;
            }
            System.out.println(sum);
        }
    }
}
/*
5 3 3
1 2
1 3
4 5
3 2 10
1 4 6
3 5 2
*/