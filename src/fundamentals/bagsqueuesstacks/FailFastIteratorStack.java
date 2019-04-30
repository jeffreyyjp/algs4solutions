package fundamentals.bagsqueuesstacks;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FailFastIteratorStack<Item> implements Iterable {

    private Node first; // top of stack (most recently added node)
    private int n; // number of items
    private int operationCount;

    private class Node {
        // nested class to define nodes
        Item item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        // Nonrecursive solution: copy each node
        Node(Node x) {
            this.item = x.item;
            this.next = x.next;
        }

        // Recursive solution:
//        Node(Node x) {
//            item = x.item;
//            if (x.next != null) {
//                next = new Node(x.next)
//            }
//        }
    }

    public FailFastIteratorStack() {
        first = null;
        n = 0;
        operationCount = 0;
    }

    // Nonrecursive solution: copy each node
    public FailFastIteratorStack(FailFastIteratorStack<Item> s) {
        if (s.first != null) {
            first = new Node(s.first);
            for (Node x = first; x.next != null; x = x.next) {
                x.next = new Node(x.next);
            }
        }
        n = s.n;
    }

    // Recursive solution:
//    public FailFastIteratorStack(Stack<Item> s) {
//        first = new Node(s.first);
//    }

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
        operationCount++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        operationCount++;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private int currentOperationCount = operationCount;

        public boolean hasNext() {
            if (currentOperationCount != operationCount) {
                throw new ConcurrentModificationException();
            }
            return current != null;
        }

        public Item next() {
            if (currentOperationCount != operationCount) {
                throw new ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
