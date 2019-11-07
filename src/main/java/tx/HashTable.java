package tx;

import java.util.LinkedList;

// key:value
// Integer: Integer
public class HashTable {
    LinkedList<int[]>[] elements; // {key,value}
    int capacity = 16;

    public HashTable() {
        elements = new LinkedList[capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        elements = new LinkedList[capacity];
    }

    int hash(int key) {
        return Math.abs(key);
    }

    boolean containsKey(int key) {
        int pos = hash(key) % capacity;
        if (elements[pos] == null)
            return false;
        for (int[] v : elements[pos]) {
            if (v[0] == key)
                return true;
        }
        return false;
    }

    void add(int key, int value) {
        int pos = hash(key) % capacity;
        if (elements[pos] == null) {
            elements[pos] = new LinkedList<>();
        }
        LinkedList<int[]> list = elements[pos];
        // already has key
        for (int[] element : list) {
            if (element[0] == key) {
                // replace
                element[1] = value;
                return;
            }
        }

        int[] element = new int[]{key, value};
        list.add(element);
    }

    int get(int key) {
        int pos = hash(key) % capacity;
        if (elements[pos] == null)
            return -1;
        for (int[] v : elements[pos]) {
            if (v[0] == key)
                return v[1];
        }
        return -1;
    }

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
        // insert
        myHashTable.add(1, 100);
        myHashTable.add(17, 1700);
        myHashTable.add(2, 200);
        myHashTable.add(3, 300);

        // query
        System.out.println(myHashTable.containsKey(1));
        System.out.println(myHashTable.containsKey(17));
        System.out.println(myHashTable.containsKey(2));
        System.out.println(myHashTable.containsKey(3));
        System.out.println(myHashTable.containsKey(4));

        // get
        System.out.println(myHashTable.get(1));
        System.out.println(myHashTable.get(17));
        System.out.println(myHashTable.get(2));
        System.out.println(myHashTable.get(3));
        System.out.println(myHashTable.get(4));
    }
}
