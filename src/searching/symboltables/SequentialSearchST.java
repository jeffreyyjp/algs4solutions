package searching.symboltables;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N = 0;

    private class Node {   // linked-list node
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {   // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;    // search hit
        return null;             // search miss
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            // Search for key. Update value if found; grow table if new.
            if (key.equals(x.key)) {
                x.val = val;
                return;                     // Search hit: update val.
            }
        }
        first = new Node(key, val, first);  // Search miss: add new node.
        N++;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

    public void delete(Key key) {
        if (first == null) {
            return;
        }
        if (key.equals(first.key)) {
            first = first.next;
        } else {
            for (Node x = first; x.next != null; x = x.next) {
                if (key.equals(x.next.key)) {
                    x.next = x.next.next;
                    break;
                }
            }
        }
    }
}
