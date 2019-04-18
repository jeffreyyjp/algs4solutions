package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class GeneralizedListQueue<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public GeneralizedListQueue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item x) {
        Node oldLast = last;
        last = new Node();
        last.item = x;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item delete(int k) {
        if (n == 0) throw new NoSuchElementException("List is empty");
        if (k < 0 || k >= n) throw new IllegalArgumentException();
        Item item = first.item;
        if (k == 0) {
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node current = first;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            item = current.next.item;
            current.next = current.next.next;
            if (current.next == null) {
                last = current;
            }
        }

        return item;

    }
}
