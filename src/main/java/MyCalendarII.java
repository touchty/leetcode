import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    /*
    * class MyCalendarTwo:
    def __init__(self):
        self.overlaps = []
        self.calendar = []

    def book(self, start, end):
        for i, j in self.overlaps:
            if start < j and end > i:
                return False
        for i, j in self.calendar:
            if start < j and end > i:
                self.overlaps.append((max(start, i), min(end, j)))
        self.calendar.append((start, end))
        return True
    * */
    ArrayList<ArrayList<Integer>> overlaps;
    ArrayList<ArrayList<Integer>> calendar;

    public MyCalendarII() {
        overlaps = new ArrayList<ArrayList<Integer>>();
        calendar = new ArrayList<ArrayList<Integer>>();
    }

    public boolean book(int start, int end) {
        for (ArrayList<Integer> l : overlaps){
            if (start < l.get(1) && end > l.get(0))
                return false;
        }

        for (ArrayList<Integer> l : calendar){
            if (start < l.get(1) && end > l.get(0)){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Math.max(start, l.get(0)));
                temp.add(Math.min(end, l.get(1)));
                overlaps.add(temp);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        calendar.add(temp);

        return true;
    }
}
class MyCalendarTwo{
    class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    ArrayList<Pair> overlaps;
    ArrayList<Pair> calendar;

    public MyCalendarTwo() {
        overlaps = new ArrayList<>();
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (Pair pair : overlaps){
            if (start < pair.j && end > pair.i)
                return false;
        }

        for (Pair pair : calendar){
            if (start < pair.j && end > pair.i){
                Pair temp = new Pair(Math.max(start, pair.i), Math.min(end, pair.j));
                overlaps.add(temp);
            }
        }
        Pair newPair = new Pair(start, end);
        calendar.add(newPair);

        return true;
    }
}