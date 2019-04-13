package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<Item> implements Iterable<Item> {

    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast == null) {
            last.next = last;
        } else {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (last == null) throw new NoSuchElementException("Queue underflow");
        Item item = last.next.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        n--;

        return item;
    }

    public Iterator<Item> iterator() {
        return new CircularListIterator();
    }

    private class CircularListIterator implements Iterator<Item> {
        private Node current = last;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.next.item;
            if (current.next == last)
                current = null;
            else {
                current = current.next;
            }
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
