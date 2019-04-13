package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings {

    private String[] a = new String[1];
    private int N = 0;
    private int head = 0;
    private int tail = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        String[] temp = new String[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[head + i];
        head = 0;
        tail = N;
        a = temp;
    }

    public void enqueue(String item) {
        if (tail == a.length)
            resize(2 * N);
        a[tail++] = item;
        N++;
    }

    public String dequeue() {
        String item = a[head];
        a[head] = null;
        head++;
        N--;
        if (N > 0 && N == a.length / 4)
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
