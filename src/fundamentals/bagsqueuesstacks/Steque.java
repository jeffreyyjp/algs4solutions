package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public Steque() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        // Add item to top of stack
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public void enqueue(Item item) {
        Node addedNode = new Node();
        addedNode.item = item;
        addedNode.next = null;
        if (first == null) {
            first = addedNode;
        } else {
            Node current = first;
            while (current.next != null)
                current = current.next;
            current.next = addedNode;
        }
        n++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

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
