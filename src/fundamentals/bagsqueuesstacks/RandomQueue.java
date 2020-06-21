package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;

    public RandomQueue() {
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

    public void enqueue(Item item) {
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int randomIndex = StdRandom.uniform(0, n);
        Item tmp = a[randomIndex];
        a[randomIndex] = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return tmp;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int randomIndex = StdRandom.uniform(0, n);
        return a[randomIndex];
    }

    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private Item[] items;
        private int i;

        public RandomIterator() {
            items = (Item[]) new Object[n];
            i = 0;
            for (int j = 0; j < n; j++) {
                items[j] = a[j];
            }
            StdRandom.shuffle(items);
        }

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            return items[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
