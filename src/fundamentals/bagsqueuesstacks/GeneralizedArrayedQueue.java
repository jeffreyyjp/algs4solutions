package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class GeneralizedArrayedQueue<Item> {

    private Item[] a;
    private int n;

    public GeneralizedArrayedQueue() {
        a = (Item[]) new Object[1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    public void insert(Item x) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = x;
    }

    public Item delete(int k) {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (k < 0 || k >= n) throw new IllegalArgumentException("Out of array's range");
        Item item = a[k];
        for (int i = k; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        a[--n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }
}
