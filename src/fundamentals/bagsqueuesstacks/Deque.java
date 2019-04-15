package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private int n;

    private class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void pushLeft(Item item) {
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        if (oldFirst == null) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        n++;
    }

    public void pushRight(Item item) {
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (oldLast == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        n--;

        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        n--;

        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private DoubleNode current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
