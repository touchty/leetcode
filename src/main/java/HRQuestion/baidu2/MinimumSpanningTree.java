package HRQuestion.baidu2;

import java.util.*;

public class MinimumSpanningTree {
    static class Connection {
        String node1;
        String node2;
        int cost;

        public Connection(String a, String b, int c) {
            node1 = a;
            node2 = b;
            cost = c;
        }
    }

    static class DisjointSet {
        Set<String> set;
        Map<String, String> map;
        int count;

        public DisjointSet() {
            count = 0;
            set = new HashSet<>();
            map = new HashMap<>();
        }

        public void MakeSet(String s) {
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

    static class ConnectionComparator1 implements Comparator<Connection> {
        @Override
        public int compare(Connection a, Connection b) {
            return a.cost - b.cost;
        }
    }

    static class ConnectionComparator2 implements Comparator<Connection> {
        @Override
        public int compare(Connection a, Connection b) {
            if (a.node1.equals(b.node1)) return a.node2.compareTo(b.node2);
            else return a.node1.compareTo(b.node1);
        }
    }

    public static List<Connection> getMST(List<Connection> connections) {
        Comparator<Connection> comparator1 = new ConnectionComparator1();
        Comparator<Connection> comparator2 = new ConnectionComparator2();
        Collections.sort(connections, comparator1);
        DisjointSet set = new DisjointSet();
        List<Connection> res = new ArrayList<>();
        for (Connection itr : connections) {
            set.MakeSet(itr.node1);
            set.MakeSet(itr.node2);
        }
        for (Connection itr : connections) {
            String s = set.Find(itr.node1);
            String t = set.Find(itr.node2);
            if (!s.equals(t)) {
                set.Union(s, t);
                res.add(itr);
                if (set.count == 1) break;
            }
        }
        if (set.count == 1) {
            Collections.sort(res, comparator2);
            return res;
        } else return new ArrayList<Connection>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Connection> connections = new ArrayList<>();
//      connections.add(new Connection("Acity","Bcity",1));
//      connections.add(new Connection("Acity","Ccity",2));
//      connections.add(new Connection("Bcity","Ccity",3));
        /*connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 1));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 1));*/

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
                connections.add(new Connection(String.valueOf(e[0]), String.valueOf(e[1]), e[2]));
            }
            List<Connection> res = getMST(connections);
        /*for (Connection c : res) {
            System.out.println(c.node1 + " -> " + c.node2 + " cost : " + c.cost);
        }*/
            int sum = 0;
            for (Connection c : res) {
                sum += c.cost;
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