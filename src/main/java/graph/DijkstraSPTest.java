package graph;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.PriorityQueue;

public class DijkstraSPTest {
    public static void main(String[] args) {
        IndexMinPQ pq = new IndexMinPQ(100);
        pq.insert(1, 10);
        pq.insert(2, 20);
        pq.insert(3, 15);
        pq.insert(4, 30);
        pq.insert(5, 3);
        int min = pq.minIndex();
        PriorityQueue<int[]> indexPq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        indexPq.add(new int[]{1, 10});
        indexPq.add(new int[]{2, 20});
        indexPq.add(new int[]{3, 5});
        indexPq.add(new int[]{4, 40});
        int minIndex = indexPq.peek()[0];
        //System.out.println(minIndex);
        //System.out.println(min);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(5);
        G.addEdge(new DirectedEdge(0, 1, 2));
        G.addEdge(new DirectedEdge(0, 2, 1));
        G.addEdge(new DirectedEdge(1, 3, 1));
        G.addEdge(new DirectedEdge(2, 3, 3));
        G.addEdge(new DirectedEdge(3, 4, 5));
        int s = 0;
        DijkstraSP dijkstraSP = new DijkstraSP(G, s);
        double d = dijkstraSP.distTo(3);
        System.out.println(d);
        Iterable<DirectedEdge> path = dijkstraSP.pathTo(4);
        for (DirectedEdge edge: path) {
            System.out.println(edge);
        }
    }
}
