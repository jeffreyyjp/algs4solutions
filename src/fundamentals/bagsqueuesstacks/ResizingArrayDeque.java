package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayDeque<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;
    private int head;
    private int tail;

    public ResizingArrayDeque() {
        a = (Item[]) new Object[1];
        n = 0;
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++)
            temp[i] = a[head + i];
        head = 0;
        tail = n;
        a = temp;
    }

    public void pushLeft(Item item) {
        if (head != 0) {
            a[--head] = item;
        } else {
            Item[] temp = (Item[]) new Object[(n + 1) * 2];
            tail = n + 1;
            temp[head] = item;
            for (int i = 1; i <= n; i++) {
                temp[i] = a[i - 1];
            }
            a = temp;
        }
        n++;
    }

    public void pushRight(Item item) {
        if (tail == a.length) {
            resize(2 * n);
        }
        a[tail++] = item;
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = a[head];
        a[head++] = null;
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = a[--tail];
        a[tail] = null;
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<Item> {

        private int i = head;

        public boolean hasNext() {
            return i < tail;
        }

        public Item next() {
            return a[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
