package searching.symboltables;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Gets the value paired with key.
     * @param key target key
     * @return value paired with key
     */
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    /**
     * Returns numbers of keys less than key.
     * @param key target key
     * @return numbers of keys less than key
     */
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    /**
     * Puts key-value pair into the table.
     * If already in table, just update the value with the key, else add a new one.
     * @param key target key
     * @param val target value
     */
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    /**
     * Returns key with index of k.
     * @param k index k in Key array.
     * @return target key with index of k
     */
    public Key select(int k) {
        return keys[k];
    }

    /**
     * Checks if specific key is in table.
     * @param key specific key to check
     * @return {@code true} if key is in table, {@code false} otherwise
     */
    public boolean contains(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns smallest key greater than or equal to key.
     * @param key target key
     * @return smallest key greater than or equal to the key
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * Returns largest key less than or equal to key.
     * @param key target key
     * @return largest key less than or equal to key
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        return keys[i - 1];
    }

    /**
     * Deletes specific key in table.
     * @param key specific key to delete
     */
    public void delete(Key key) {
        if (isEmpty()) return;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            int j = i;
            for (; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            keys[j] = null;
            vals[j] = null;
        }
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(hi);
        return q;
    }
}
