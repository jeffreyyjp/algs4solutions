package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_29 {

    public static void main(String[] args) {
        // Using CircularQueue class.
        CircularQueue<String> cq = new CircularQueue<>();
        cq.enqueue("I");
        cq.enqueue("Love");
        cq.enqueue("You");

        // circular linked list traverse.
        for (String s : cq) {
            StdOut.println(s);
        }
        StdOut.println(cq.size());

        StdOut.println(cq.dequeue());
        StdOut.println(cq.dequeue());
        StdOut.println(cq.dequeue());
//        StdOut.println(cq.dequeue());   // this statement will throw underflow.
    }
}
