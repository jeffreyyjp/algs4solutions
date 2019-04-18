package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings {

    private String[] a; // stack entries
    private int N; // size

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[--N];
    }
}
