package searching.hashtables;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int M) {
        // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> tmp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                tmp.put(key, st[i].get(key));
            }
        }
        this.M = tmp.M;
        this.N = tmp.N;
        this.st = tmp.st;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");

        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        if (N >= 10 * M) resize(2 * M);

        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[hash(key)].put(key, val);
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key))
            N--;
        st[i].delete(key);

        if (M > INIT_CAPACITY && N <= 2 * M) resize(M / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}
