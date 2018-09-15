package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
* The squares divide the number line into many segments with different heights. Therefore we can use a TreeMap to store
* the number line. The key is the starting point of each segment and the value is the height of the segment. For every
* new falling square (s, l), we update those segments between s and s + l.
*
* __aaa
* __aaa
* __aaa
* _aa
* _aa___a
* */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // at first, there is only one segment starting from 0 with height 0
        map.put(0, 0);

        // The global max height is 0
        int max = 0;

        for(int[] position : positions) {

            // the new segment
            int start = position[0], end = start + position[1];

            // find the height among this range
            Integer key = map.floorKey(start);
            int h = map.get(key);
            key = map.higherKey(key);
            while(key != null && key < end) {
                h = Math.max(h, map.get(key));
                key = map.higherKey(key);
            }
            h += position[1];

            // update global max height
            max = Math.max(max, h);
            list.add(max);

            // update new segment and delete previous segments among the range
            int tail = map.floorEntry(end).getValue();
            map.put(start, h);
            map.put(end, tail);
            key = map.higherKey(start);
            while(key != null && key < end) {
                map.remove(key);
                key = map.higherKey(key);
            }
        }
        return list;
    }

    public List<Integer> fallingSquaresV2(int[][] positions) {
        int n=positions.length;
        int max=0;
        List<Integer> res=new ArrayList<>();
        Node head=new Node(0,0);
        for(int[] p:positions){
            Node prev=head;
            while(prev.next!=null&&prev.next.x<p[0])
                prev=prev.next;
            int lasth=prev.h;
            int h=(prev.next==null||prev.next.x>p[0])?prev.h+p[1]:p[1];
            Node post=prev.next;
            while(post!=null&&post.x<p[0]+p[1]){
                h=Math.max(h,post.h+p[1]);
                lasth=post.h;
                post=post.next;
            }
            Node cur=new Node(p[0],h);
            prev.next=cur;
            if(post==null||post.x>p[0]+p[1]){
                cur.next=new Node(p[0]+p[1],lasth);
                cur=cur.next;
            }
            cur.next=post;
            max=Math.max(max,h);
            res.add(max);
        }
        return res;
    }
    class Node{
        int x;
        int h;
        Node next;
        public Node(int x,int h){
            this.x=x;
            this.h=h;
        }
    }
}
