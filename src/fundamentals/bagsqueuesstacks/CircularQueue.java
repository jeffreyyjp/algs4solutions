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

    public CircularQueue() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return last == null;
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
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = last.next.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        n--;

        return item;
    }

    // Used for exercise1_3_47
    public void catenation(CircularQueue<Item> other) {
        if (this.isEmpty() || other.isEmpty())
            return;

        Node thisFirst = last.next;
        last.next = other.last.next;
        other.last.next = thisFirst;
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
