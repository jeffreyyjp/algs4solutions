package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_3_35 {

    public static void main(String[] args) {
        RandomQueue<String> rq = new RandomQueue<>();
        rq.enqueue("I");
        rq.enqueue("Love");
        rq.enqueue("You");

        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println(rq.sample());
        StdOut.println();

        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
    }
}
