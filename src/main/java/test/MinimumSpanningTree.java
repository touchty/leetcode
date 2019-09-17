package test;

import java.util.*;

// https://www.ctolib.com/topics-80931.html
/*
Amazon-OA2面经：城市连接问题，即MST
 beautifulgorilla 发布于2年前 0 人点赞   0 条问题
题目内容
在写这一篇的时候，这题非常出名，因为16年秋首批爆出的video第三题都是这道。做出来的就能拿到video，
价值108k+18k美刀至少，比摸金校尉三人合体都多，做不出来也能免费去西雅图来一圈儿，吃喝减半住宿全免，
但群面通过率远低于video，所以为了生存这道题必须跑出来。
题目内容是这样的，给十几个城市供电，连接不同城市的花费不同，让花费最小同时连到所有的边。给出一系列connection类，
里面是edge两端的城市名和它们之间的一个cost，找出要你挑一些边，把所有城市连接起来并且总花费最小。
不能有环，最后所以城市要连成一个连通块。

不能的话输出空表，最后还要按城市名字排序输出，按照node1来排序,如果一样的话再排node2。

输入:

{"Acity","Bcity",1}

("Acity","Ccity",2}

("Bcity","Ccity",3}

输出：

("Acity","Bcity",1}

("Acity","Ccity",2}

补充一句，test case一共有6个。

解决思路
思路会有很多，我的想法是Kruskal+Union Find，将输入的一群connection类（其实就是边）按照cost从小到大排序(Kruskal算法)，然后遍历。挑出一个connection之后，看一下edge两头的城市属于哪一个团伙(Union Find)。如果落单了就加入，不同团伙就合并，都是落单了就抱团。

最后有两个要求，1.如果MST不存在，那么输出一个空表（应该不是null）。这个可以用union find思想，最后查有几个union，如果大家都是自己人，那么就正常输出，如果大家是1，有零星2了，那就空表了。2.输出要按照城市的名字排序，这个不难，就正常排序就行。
 */
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
        connections.add(new Connection("A", "B", 6));
        connections.add(new Connection("B", "C", 4));
        connections.add(new Connection("C", "D", 5));
        connections.add(new Connection("D", "E", 8));
        connections.add(new Connection("E", "F", 1));
        connections.add(new Connection("B", "F", 10));
        connections.add(new Connection("E", "C", 9));
        connections.add(new Connection("F", "C", 7));
        connections.add(new Connection("B", "E", 3));
        connections.add(new Connection("A", "F", 1));

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
