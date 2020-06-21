package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {

    private String[] a = new String[1];
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        String[] tmp = new String[max];
        for (int i = 0; i < n; i++)
            tmp[i] = a[head + i];
        head = 0;
        tail = n;
        a = tmp;
    }

    public void enqueue(String item) {
        if (tail == a.length)
            resize(2 * n);
        a[tail++] = item;
        n++;
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        String item = a[head];
        a[head++] = null;
        n--;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);

        return item;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        q.enqueue("to");
        q.enqueue("be");
        q.enqueue("or");
        q.enqueue("not");
        q.enqueue("to");
        StdOut.println(q.dequeue());
        q.enqueue("be");
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
    }
}
