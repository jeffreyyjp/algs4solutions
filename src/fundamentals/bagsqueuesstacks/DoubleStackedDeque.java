package fundamentals.bagsqueuesstacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleStackedDeque<Item> implements Iterable<Item> {

    private Stack<Item> leftStack;
    private Stack<Item> rightStack;

    public DoubleStackedDeque() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }

    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    public int size() {
        return leftStack.size() + rightStack.size();
    }

    public void pushLeft(Item item) {
        leftStack.push(item);
    }

    public void pushRight(Item item) {
        rightStack.push(item);
    }

    public Item popLeft() {
        if (leftStack.isEmpty()) {
            while (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
        }
        if (leftStack.isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }

        return leftStack.pop();
    }

    public Item popRight() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        if (rightStack.isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }

        return rightStack.pop();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        public boolean hasNext() {
            return !isEmpty();
        }

        public Item next() {
            return popLeft();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
