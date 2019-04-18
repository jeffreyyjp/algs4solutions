package fundamentals.bagsqueuesstacks;

import java.util.NoSuchElementException;

public class Buffer {

    private Stack<Character> current;
    private Stack<Character> holder;

    public Buffer() {
        current = new Stack<>();
        holder = new Stack<>();
    }

    // insert c at the cursor position
    public void insert(char c) {
        current.push(c);
    }

    // delete and return the character at the cursor
    public char delete() {
        if (current.isEmpty()) throw new NoSuchElementException("Buffer is empty");
        return current.pop();
    }

    // move the cursor k positions to the left
    public void left(int k) {
        if (k > current.size()) throw new IllegalArgumentException();
        for (int i = 0; i < k; i++) {
            holder.push(current.pop());
        }
    }

    // move the cursor k positions to the right
    public void right(int k) {
        if (k > holder.size()) throw new IllegalArgumentException();
        for (int i = 0; i < k; i++) {
            current.push(holder.pop());
        }
    }

    // number of characters in the buffer
    public int size() {
        return current.size() + holder.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character c : current) {
            holder.push(c);
        }
        for (Character c : holder) {
            sb.append(c).append(" ");
        }

        return sb.toString();
    }
}
