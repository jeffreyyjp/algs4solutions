package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int n;

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        // Using Node implementation copying.
//        Node(Node x) {
//            this.item = x.item;
//            this.next = x.next;
//        }
    }

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    // Using array implementation copying.
    public Queue(Queue<Item> q) {
        if (q.first != null) {
            int size = q.n;
            Item[] a = (Item[]) new Object[q.n];
            for (int i = 0; i < size; i++) {
                a[i] = q.dequeue();
            }
            for (int i = 0; i < size; i++) {
                q.enqueue(a[i]);
                this.enqueue(a[i]);
            }
        }
    }

    // Using Node implementation copying.
//    public Queue(Queue<Item> q) {
//        if (q.first != null) {
//            first = new Node(q.first);
//            Node x = first;
//            for (; x.next != null; x = x.next) {
//                x.next = new Node(x.next);
//            }
//            last = x;
//            n = q.n;
//        }
//    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        // Add item to the end of the list.
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
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
