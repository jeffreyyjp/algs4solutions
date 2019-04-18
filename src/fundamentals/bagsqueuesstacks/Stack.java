package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node first; // top of stack (most recently added node)
    private int n; // number of items

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

    public Stack() {
        first = null;
        n = 0;
    }

    // Nonrecursive solution: copy each node
    public Stack(Stack<Item> s) {
        if (s.first != null) {
            first = new Node(s.first);
            for (Node x = first; x.next != null; x = x.next) {
                x.next = new Node(x.next);
            }
        }
        n = s.n;
    }

    // Recursive solution:
//    public Stack(Stack<Item> s) {
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
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
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

    public static void main(String[] args) {
        // Create a stack and push/pop strings as directed on StdIn.
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
