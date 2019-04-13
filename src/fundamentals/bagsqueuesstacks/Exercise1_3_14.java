package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_14 {

    public static void main(String[] args) {
        // Using ResizingArrayQueueOfStrings class.
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
