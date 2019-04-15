package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private int n;

    private class DoubleNode {
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }

    public DoubleLinkedList() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insertBegin(Item item) {
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

    public void insertEnd(Item item) {
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

    public Item removeBegin() {
        if (isEmpty()) throw new NoSuchElementException("Empty list");
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

    public Item removeEnd() {
        if (isEmpty()) throw new NoSuchElementException("Empty list");
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

    public void insertBefore(DoubleNode current, DoubleNode inserted) {
        if (current == null || inserted == null) {
            return;
        }

        DoubleNode currentBefore = current.prev;
        current.prev = inserted;
        inserted.prev = currentBefore;
        inserted.next = current;
        if (currentBefore != null) {
            currentBefore.next = inserted;
        } else {
            first = inserted;
        }
        n++;
    }

    public void insertAfter(DoubleNode current, DoubleNode inserted) {
        if (current == null || inserted == null) {
            return;
        }

        DoubleNode currentAfter = current.next;
        current.next = inserted;
        inserted.prev = current;
        inserted.next = currentAfter;
        if (currentAfter != null) {
            currentAfter.prev = inserted;
        } else {
            last = inserted;
        }
        n++;
    }

    public void remove(Item item) {
        DoubleNode current = first;
        while (current != null) {
            if (current.item == item) {
                if (current == first) {
                    removeBegin();
                } else if (current == last) {
                    removeEnd();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    n--;
                }
                break;
            }
            current = current.next;
        }
    }

    public Iterator<Item> iterator() {
        return new DoubleLinedListIterator();
    }

    private class DoubleLinedListIterator implements Iterator<Item> {

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
