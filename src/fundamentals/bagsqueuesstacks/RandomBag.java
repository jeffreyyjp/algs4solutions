package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {

    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public RandomBag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Item[] a;
        private int i;

        public ListIterator() {
            a = (Item[]) new Object[n];
            i = 0;
            Node current = first;
            for (int j = 0; j < n; j++) {
                a[j] = current.item;
                current = current.next;
            }
            StdRandom.shuffle(a);
        }

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            return a[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
